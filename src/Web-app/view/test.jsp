<%@ page contentType="text/html;charset=MS949" %>
<%@ page import="org.apache.log4j.Logger" %>
<%@ page import="org.apache.logging.log4j.Logger" %>

<%!
    static Logger logger = Logger.getLogger("test.jsp");
%>

<%
    logger.fatal("fatal!!");

    logger.fatal("fatal2!!", new NullPointerException("���Դϴٿ�"));

    logger.error("error!", new NumberFormatException());

    logger.error("error!2");

    logger.warn("warn");

    logger.info("info");

    logger.debug("debug");
%>



��ó: https://www.jami.name/205 [[jami] - for the better]