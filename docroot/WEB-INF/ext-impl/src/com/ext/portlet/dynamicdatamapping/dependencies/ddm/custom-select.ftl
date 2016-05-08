<#include "../init.ftl">

<#assign multiple = false>

<#if required>
	<#assign label = label + " (" + languageUtil.get(requestedLocale, "required") + ")">
</#if>

<@aui["field-wrapper"] data=data>
	<@aui.select cssClass=cssClass helpMessage=escape(fieldStructure.tip) label=escape(label) multiple=multiple name=namespacedFieldName>
	</@aui.select>
	
	${fieldStructure.children}
</@>

<script>
AUI().ready(function(A) {
	
	var namespacedField = A.one('#${portletNamespace}${namespacedFieldName}');

	if(namespacedField){
		Liferay.Service(
			'${fieldStructure.urlService}',
			function(obj) {
				A.each(obj, function(value) {
					if(value == '${fieldValue}'){
						namespacedField.append("<option selected='selected' value='"+value+"'>"+value+"</option>");
					}
					else{
						namespacedField.append("<option value='"+value+"'>"+value+"</option>");
					}
				});
			}
		);
	}
});
</script>