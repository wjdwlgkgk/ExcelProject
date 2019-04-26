<script>
    var ruleId;
    var sqliteCtrl;
    var insertobj;
    var fileName;
    var regText;

    var input_text = [];
    var input_opt = "i";        // cisco , avaya delimiter
    var input_alteon = "\/";  // alteon line delimiter
    var input_deli ="\n";     // citrix delimiter

    var tablenm = "Network_Data"; // db insert table name

    var total_cnt = 0; // configuration file all line count

    var output_result = true;
    var result_info;
    var result_okbad;

    function push_text(text) {
        input_text.push(text);
        total_cnt++;
    }

    // line regex matching
    function matcher(type, text, regex, opt) {
        var ret;
        var match = new RegExp(regex);
        ret = match.exec(text);
        return ret;
    }

    // cisco line matching
    function linematcher(type , text , regex , opt, startline , endline){
        var ret;

        for(var i=startline; i &lt;= endline; i++){
            if(input_text[i].match(/!/gi) || input_text[i].match(/^line.*/gi)){
                break;
            }else{
                if(input_text[i].match(regex)){
                    ret = input_text[i];
                }
            }
        }
        return ret;
    }

    function dbInsert(text , regex , patternnm , input , dbnm ){
        var bulk = "INSERT INTO " + dbnm + " ( id , filename , input_line , pattern , type , start , end , find ) ";
        var cnt = 0;
        for(var k=0; k &lt; text.length; k++){
            var values = matcher("exec" , text[k], regex , input);

            if(values != null){
                cnt++;
                for(var v=0; v &lt; values.length; v++){
                    bulk += " SELECT " +  "'" +ruleId + "',  '" +fileName + "' , '" + input_text[k] + "' , '" + patternnm + "' , 'O', '" + k+1 + "' , '" + k+1 + "' ,'" + values[v] + "' UNION ALL ";
                }
            }
        }
        if(cnt &gt; 0){
            dbInsertRoleQuery(bulk.slice(0, -10) );
        }else{
            dbInsertRole("username", "CISCO601"+tablenm, "No data" , "No data" , "B" , 0 , 0 , "No data");
        }
    }
    function dbInsertRoleQuery(sql){
        sqliteCtrl.insertSql(sql);
    }

    function regexCnt(regex, input){
        var cnt = 0;
        for(var k=0; k &lt; input_text.length; k++){
            var values = matcher("exec", input_text[k], regex, input);

            if(values != null){
                cnt++;
            }
        }
        return cnt;
    }
    function dbInsertRole(result , dbnm, regex , patternnm , type , start , end , find){
        var query = "INSERT INTO " + dbnm + "(id, filename, input_line , pattern , type , start , end , find) VALUES ( ?,?,?,?,?,?,?,? )";
        insertobj.add(result);
        insertobj.add(regex);
        insertobj.add(type);
        insertobj.add(start);
        insertobj.add(end);
        insertobj.add(result);
        sqliteCtrl.insert(query , ruleId , fileName , result , patternnm , type , start , end , find);

    }


    function cisco601() {
        dbInsert(input_text , "username.*" , "username" , input_opt , "CISCO601"+tablenm );
    }

    function execmain() {
        cisco601();
    }
</script>