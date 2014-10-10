package org.oep.egovcore.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.WordUtils;
/**
*
* BeanGenerator  class
*   
* This class is used to declare BeanGenerator 
*
* 
* 
* History:
*  
*   DATE         AUTHOR      DESCRIPTION 
*  --------------------------------------------------------
*  10-Aug-2012   NamDH       Create new
*  15-Sept-2012  LanDD       Add code to generate secret confirmation code
*
*/
public class BeanGenerator {
	
	/**
	  * This is Function main
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String[] args
	  * @return 
	  */
	public static void main(String[] args) throws Exception {
		
		generate(org.oep.cmon.dao.beans.cauhinhlienthong.SourceCauHinhLienThong.class);
	}
	
	public static final String BASE_DIR_PATH = "D:\\DN67New\\liferay-plugins-sdk-6.1.0-ce-b4-20111118\\portlets\\cmon-app-portlet\\docroot\\WEB-INF\\src";
	public static final String INTERFACE_BASE_DIR_PATH = "D:\\DN67New\\liferay-plugins-sdk-6.1.0-ce-b4-20111118\\portlets\\cmon-app-portlet\\docroot\\WEB-INF\\service";
	
	/**
	  * This is Function generate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Class<?> sourceClass
	  * @return void
	  */
	public static void generate(Class<?> sourceClass) throws IOException {
		generate(sourceClass, null);
	}
	/**
	  * This is Function generate
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Class<?> sourceClass, Class<?> parentInterface
	  * @return void
	  */
	public static void generate(Class<?> sourceClass, Class<?> parentInterface) throws IOException {
		
		if ( ! sourceClass.getSimpleName().startsWith("Source") ) {
			return;
		}
		
		String implSuffix = "Impl";
		String interfaceName = sourceClass.getSimpleName().substring(6);
		String baseClassName = "Base" + interfaceName + implSuffix;
		String className = interfaceName + implSuffix;
		String packageName = sourceClass.getPackage().getName();

		String parentClassName = StringPool.BLANK;
		String parentClassPackageName = StringPool.BLANK;
		String importParentClass = StringPool.BLANK;
		String parentInterfaceName = StringPool.BLANK;
		String importParentInterface = StringPool.BLANK;
		StringBuilder extendsClass = new StringBuilder();
		String extendsInterface = StringPool.BLANK;
		String extendsParentClass = StringPool.BLANK;
		boolean isParentClassExist = true;
		
		if (parentInterface != null) {
			parentInterfaceName = parentInterface.getSimpleName();
			parentClassName = parentInterfaceName + implSuffix;
			parentClassPackageName = parentInterface.getPackage().getName();
			
			try {
				Class.forName(parentClassPackageName + "." + parentClassName);
			} catch (Exception e) {
				isParentClassExist = false;
			}
			
			if (isParentClassExist) {
				extendsParentClass = " extends " + parentClassName;
				importParentClass = "\nimport " + parentClassPackageName +  "." + parentClassName + ";";
			}
			
			importParentInterface = "\n\nimport " + parentClassPackageName + "." + parentInterfaceName + ";";
			extendsInterface = " extends " + parentInterfaceName;
		}
		
		extendsClass.append(extendsParentClass);
		extendsClass.append(" implements ");

		if (parentInterface == null || !isParentClassExist) {
			extendsClass.append("java.io.Serializable, " + interfaceName);
		} else {
			extendsClass.append(interfaceName);
		}
		
		StringBuilder interfaceContent = new StringBuilder("package ").append(packageName).append( ";" );
		interfaceContent.append(importParentInterface);
		interfaceContent.append("\n\npublic interface ").append(interfaceName);
		interfaceContent.append(extendsInterface);
		interfaceContent.append(" {");
		
		StringBuilder baseContent = new StringBuilder("package ").append(packageName).append( ";" );
		baseContent.append(importParentClass);
		
		StringBuilder baseClassHead = new StringBuilder("\n\n@SuppressWarnings(\"serial\")\npublic abstract class ");
		baseClassHead.append(baseClassName);
		baseClassHead.append(extendsClass);
		baseClassHead.append(" {\n\n\tpublic ").append(baseClassName).append(" () {}");
		
		StringBuilder imports = new StringBuilder();
		StringBuilder methods = new StringBuilder();
		StringBuilder props = new StringBuilder("\n");
		String setter;
		String setterPattern = "\n\n\tpublic void set%s(%s %s) {\n\t\t_%s = %s;\n\t}";
		String setterPatternObject = "\n\n\tpublic void set%s(%s %s) {\n\t\tif (%s != null) {\n\t\t\t_%s = %s;\n\t\t}\n\t}";
		String setterPatternString = "\n\n\tpublic void set%s(%s %s) {\n\t\tif (%s != null) {\n\t\t\t_%s = %s.trim();\n\t\t}\n\t}";
		String getterPattern = "\n\n\tpublic %s get%s() {\n\t\treturn _%s;\n\t}";
		String getterPatternLong = "\n\n\tpublic %s get%s(boolean notNull) {\n\t\tif (notNull && _%s == null) {\n\t\t\treturn 0L;\n\t\t}\n\t\treturn _%s;\n\t}";
		String propPatter = "\n\tprivate %s _%s;";
		String propPatternString = "\n\tprivate String _%s = StringPool.BLANK;";
		String propPatterInteger = "\n\tprivate Integer _%s = 0;";
		String propPatterDouble = "\n\tprivate Double _%s = 0D;";
		String propPatterFloat = "\n\tprivate Float _%s = 0F;";
		String propPatterBoolean = "\n\tprivate Boolean _%s = false;";
		
		String interfaceSetter = "\n\tpublic void set%s(%s %s);";
		String interfaceGetter = "\n\tpublic %s get%s();";
		String interfaceGetterLong = "\n\tpublic %s get%s(boolean notNull);";
		boolean hasStringField = false;
		
		String name, capName, type;
		for (Field field : sourceClass.getDeclaredFields()) {
			name = field.getName();
			capName = WordUtils.capitalize(name);
			type = field.getType().getSimpleName();
			
			if (type.equals(Date.class.getSimpleName())) {
				type = Date.class.getName();
			}
			
			if (type.equals(String.class.getSimpleName())) {
				
				props.append(String.format(propPatternString, name));
				setter = String.format(setterPatternString, capName, type, name, name, name, name);
				
			} else if (type.equals(Integer.class.getSimpleName())) {
				
				props.append(String.format(propPatterInteger, name));
				setter = String.format(setterPatternObject, capName, type, name, name, name, name);
				
			} else if (type.equals(Double.class.getSimpleName())) {
				
				props.append(String.format(propPatterDouble, name));
				setter = String.format(setterPatternObject, capName, type, name, name, name, name);
				
			} else if (type.equals(Float.class.getSimpleName())) {
				
				props.append(String.format(propPatterFloat, name));
				setter = String.format(setterPatternObject, capName, type, name, name, name, name);
				
			} else if (type.equals(Boolean.class.getSimpleName())) {
				
				props.append(String.format(propPatterBoolean, name));
				setter = String.format(setterPatternObject, capName, type, name, name, name, name);
				
			} else {
				
				// For Long and primitive types
				props.append(String.format(propPatter, type, name));
				setter = String.format(setterPattern, capName, type, name, name, name);
			}
			
			hasStringField = hasStringField || (type.equals(String.class.getSimpleName()));
			
			interfaceContent.append(String.format(interfaceSetter, capName, type, name));
			methods.append(setter);
			
			if (type.equals(Long.class.getSimpleName())) {
				interfaceContent.append(String.format(interfaceGetterLong, type, capName));
				methods.append(String.format(getterPatternLong, type, capName, name, name));
			} else {
				interfaceContent.append(String.format(interfaceGetter, type, capName));
				methods.append(String.format(getterPattern, type, capName, name));
			}
		}
		
		if (hasStringField) {
			imports.append("\n\nimport org.oep.egovcore.util.StringPool;");
		}
		
		baseContent
			.append(imports)
			.append(baseClassHead)
			.append(methods)
			.append(props)
			.append("\n}")
			.toString();
		
		interfaceContent.append("\n}");
		
		// Bean interface
		_writeFile(_getJavaSourceFilePathForInterface(packageName, interfaceName), interfaceContent.toString());

		// Bean base class
		_writeFile(_getJavaSourceFilePath(packageName, baseClassName), baseContent.toString());
		
		// Bean class
		String path = _getJavaSourceFilePath(packageName, className);
		
		if (!new File(path).exists()) {
			
			StringBuilder content = new StringBuilder("package ").append(packageName) 
				.append(";\n\n@SuppressWarnings(\"serial\")")
				.append("\npublic class ").append(className).append(" extends ").append(baseClassName).append(" {")
				.append("\n\n\tpublic " + className + "() {}")
			;
			
			if (parentInterface != null && !isParentClassExist) {
				content.append(_generateInterfaceMethodImplString(parentInterface));
			}
			
			content.append("\n}");
			
			_writeFile(path, content.toString());
		}
		
	}
	
	
	/**
	  * This is Function _generateInterfaceMethodImplString
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param Class<?> parentInterface
	  * @return String
	  */
	private static String _generateInterfaceMethodImplString(Class<?> parentInterface) throws IOException {
		String path = _getJavaSourceFilePath(parentInterface.getPackage().getName(), parentInterface.getSimpleName());
		StringBuilder out = new StringBuilder();
		BufferedReader br = null;
		br = new BufferedReader(new FileReader(path));
		String line;
		while ((line = br.readLine()) != null) {
			if (!line.contains(StringPool.EQUAL)
				&& !line.contains("package ")
				&& !line.contains("import ")
				&& !line.contains("{")
				&& !line.contains("}")
				&& !line.contains("@")
				&& !line.trim().isEmpty()
			) {
				line = line.trim().replaceAll(" +", " ");
				String type = line.split(" ")[1];
				
				boolean isTypeVoid = type.equals("void");
				boolean isTypeObject = !isTypeVoid 
					&& !type.equals("int") 
					&& !type.equals("long")
					&& !type.equals("boolean")
					&& !type.equals("double")
					&& !type.equals("float")
					&& !type.equals("char");
				
				out.append(System.getProperty("line.separator"));
				out.append(System.getProperty("line.separator"));
				out.append("\t");
				if (isTypeVoid) {
					out.append(StringUtils.stripEnd(line, ";") + " {}");
				} else if (isTypeObject) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn null;\n\t}");
				} else if (type.equals("int") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn 0;\n\t}");
				} else if (type.equals("long") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn 0L;\n\t}");
				} else if (type.equals("boolean") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn false;\n\t}");
				} else if (type.equals("double") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn 0D;\n\t}");
				} else if (type.equals("float") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn 0F;\n\t}");
				} else if (type.equals("char") ) {
					out.append(StringUtils.stripEnd(line, ";") + " {\n\t\treturn '';\n\t}");
				}
			}
		}
		br.close();
		return out.toString();
	}
	
	/**
	  * This is Function _writeFile
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String path, String content
	  * @return void
	  */
	private static void _writeFile(String path, String content) throws FileNotFoundException, UnsupportedEncodingException {
		new File(new File(path).getParent()).mkdirs();
		PrintWriter writer = new PrintWriter(path, "UTF-8");
		writer.print(content);
		writer.close();
	}
	
	/**
	  * This is Function _getJavaSourceFilePath
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String packageName, String className
	  * @return String
	  */
	private static String _getJavaSourceFilePath(String packageName, String className) {
		return BASE_DIR_PATH + File.separator + packageName.replace('.', '\\') + File.separator + className + ".java";
	}
	
	/**
	  * This is Function _getJavaSourceFilePathForInterface
	  * Version: 1.0
	  *  
	  * History: 
	  *   DATE        AUTHOR      DESCRIPTION 
	  *  ------------------------------------------------- 
	  *  3-March-2013  Nam Dinh    Create new
	  * @param String packageName, String className
	  * @return  String
	  */
	private static String _getJavaSourceFilePathForInterface(String packageName, String className) {
		return INTERFACE_BASE_DIR_PATH + File.separator + packageName.replace('.', '\\') + File.separator + className + ".java";
	}
}
