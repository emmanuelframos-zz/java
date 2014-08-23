<%@ taglib prefix="s" uri="/struts-tags"%>

<h3>Employee List</h3>
<table>
	<s:iterator value="employees">
		<tr>
			<td style="background: #CCCCCC">
			<s:property value="id"/>
			</td>
			<td style="background: #CCCCCC">
			<s:property value="firstName"/>
			</td>
			<td style="background: #CCCCCC">
			<s:property value="lastName"/>
			</td>
		</tr>
	</s:iterator>	
</table>