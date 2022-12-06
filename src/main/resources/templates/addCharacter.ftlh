<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>GoT - Add Character</title>
</head>
<body>

<p>House: ${houseName}</p>

<form method="post">
<p>
  Father:
  <select name="father">
    <option></option>
      <#list characters as c>
        <option>${c.name}</option>
      </#list>
  </select>

  Mother:
  <select name="mother">
    <option></option>
      <#list characters as c>
        <option>${c.name}</option>
    </#list>>
  </select>
</p>
<p>Name: <input type="text" name="name"> <button>Add</button></p>
</form>

</body>
</html>