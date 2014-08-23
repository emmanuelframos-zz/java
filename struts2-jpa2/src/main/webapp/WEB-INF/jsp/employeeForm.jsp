<%@ taglib prefix="s" uri="/struts-tags"%>

<s:form name="frmEmployeeData" action="employee!addEmployee">
	<s:textfield name="employee.firstName" label="First Name:" />
	<s:textfield name="employee.lastName" label="Last Name:" />
	<s:submit name="add" title="Add" value="Add" />
</s:form>