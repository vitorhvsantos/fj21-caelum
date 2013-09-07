<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3> Altera Tarefa = ${tarefa.id}</h3>

<form:errors path="tarefa.descricao"  />
<form:errors path="tarefa.dataFinalizacao" />
<form action="alteraTarefa" method="post">
Descricao <input type="text" name="descricao" value="${tarefa.descricao}" /> <br />

Finalizado ? <input type="checkbox" name="finalizado" value="true" ${tarefa.finalizado ? 'checked' : '' } />
<br />
Data Finalizacao <br />
<input type="text" name="dataFinalizacao" 
value="<fmt:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/MM/yyyy"/> "/><br />
<input type="hidden" value="${tarefa.id}" name="id">
<input type="submit" value="Salvar"/>


</form>

</body>
</html>