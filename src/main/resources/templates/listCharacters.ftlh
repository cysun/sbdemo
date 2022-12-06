<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoT - Characters</title>
</head>
<body>
	<form method="get">
		<p>
			<select name="houseName">
				<#list houses as h>
				<option
					<#if h.name == house.name>selected</#if>
				>${h.name}</option>
				</#list>
			</select>
			<button>Select</button>
			<a href="AddHouse">Add House</a> | <a
				href="AddCharacter?houseName=${house.name}">Add Character</a>
		</p>
	</form>
	<table border="1" cellpadding="5" cellspacing="2">
		<thead>
			<tr>
				<th>Name</th>
				<th>Father</th>
				<th>Mother</th>
			</tr>
		</thead>
		<tbody>
			<#list house.characters as c>
			<tr>
				<td>${c.name}</td>
				<td>${c.father!}</td>
				<td>${c.mother!}</td>
			</tr>
			</#list>
		</tbody>
	</table>
</body>
</html>