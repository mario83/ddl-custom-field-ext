package com.ext.portlet.dynamicdatamapping.util;

import java.net.URL;

import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.dynamicdatamapping.util.DDMXSDImpl;

public class CustomDDMXSDImpl extends DDMXSDImpl{
	
	@Override
	protected URL getResource(String name) {
		
		if(StringUtil.endsWith(name, "custom-select.ftl")){
			
			URL url = null;
			if(StringUtil.endsWith(name, "readonly/ddm-custom-select.ftl")){
				url = super.getResource(_EXT_TPL_READONLY_PATH + "custom-select.ftl");
			}else {
				url = super.getResource(_EXT_TPL_PATH + "custom-select.ftl");
			}
			if(url != null){
				return url;
			}
		}
		
		return super.getResource(name);
	}

	private static final String _EXT_TPL_PATH = 
		"com/ext/portlet/dynamicdatamapping/dependencies/ddm/";
	
	private static final String _EXT_TPL_READONLY_PATH = 
		"com/ext/portlet/dynamicdatamapping/dependencies/readonly/";
}
