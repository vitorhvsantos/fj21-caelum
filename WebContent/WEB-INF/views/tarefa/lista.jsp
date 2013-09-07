<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="resources/js/jquery.js" ></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
function finalizaAgora(id){
	$.post("finalizaTarefa", {'id':id},
	function () {
	$("#t"+id).html("<a href='#' onclick='desfinalizaAgora("+id+")'>Definalizar Agora</a>");
		
	});		
}

function deletaAgora(id){
	$.post("removeTarefa", {'id':id}, 
		function (){
		$("#l"+id).remove();
		}	);
}

function desfinalizaAgora(id){
	$.post("desfinalizaTarefa", {'id':id},
	function () {
	$("#t"+id).html("<a href='#' onclick='finalizaAgora("+id+")'>Finalizar Agora</a>");
		
	});		
}


</script>



<table border="3" align="center" >
<tr bgcolor="#677279">
<th>ID</th>
<th>Descricao</th>
<th>Finalizado ?</th>
<th>Data Finalização</th>
<th></th>
<th></th>
</tr>
<c:forEach items="${tarefa}" var="t" varStatus="v">
<tr bgcolor="#${v.count % 2 ==0 ? '677279' : 'ff6600' }" id="l${t.id}">
<td>${t.id}</td>
<td>${t.descricao}</td>
<c:if test="${!t.finalizado}">
<td id="t${t.id}"><a href="#" onclick="finalizaAgora(${t.id})" >Finalizar Agora</a> </td>
</c:if>
<c:if test="${t.finalizado}">
<td id="t${t.id}"><a href="#" onclick="desfinalizaAgora(${t.id})">Definalizar Agora</a></td>
</c:if>
<td>
<fmt:formatDate value="${t.dataFinalizacao.time}" pattern="dd/MM/yyyy"/>
</td>
<td><a href="#" onclick="deletaAgora(${t.id})">Deletar</a></td>

<td><a href="mostraTarefa?id=${t.id}">Alterar</a> </td>

</tr>
</c:forEach>
</table>



</body>
</html>