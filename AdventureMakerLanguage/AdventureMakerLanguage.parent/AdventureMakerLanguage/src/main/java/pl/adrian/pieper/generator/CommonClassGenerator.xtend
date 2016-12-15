package pl.adrian.pieper.generator

import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import org.eclipse.xtext.generator.IFileSystemAccess2

class CommonClassGenerator {

    @Accessors
    final String packageName;

    @Accessors
    final String classType;

    final String packagePath;
    final List<String> interfaces = new ArrayList;
    private List<String> imports = new ArrayList;
    private List<String> staticImports = new ArrayList;

    new(String packageName, String classType){
        packagePath = packageName.replaceAll("\\.","/") + "/"
        this.packageName = packageName
        this.classType = classType
    }

    public def addInterfaces(String... interfaces) {

        for(String i : interfaces){
            this.interfaces.add(i);
        }
    }

    public def addImports(String... imports) {

        for(String i : imports){
            this.imports.add(i);
        }
    }

    public def addStaticImports(String... staticImports) {

        for(String i : staticImports){
            this.staticImports.add(i);
        }
    }

    def generateImports() {

        return '''
            «FOR imp : imports»
                import «imp»;
            «ENDFOR»
            «FOR imp : staticImports»
                import static «imp»;
            «ENDFOR»
        '''
    }

    public def generateFile(String rootPath, IFileSystemAccess2 fsa, String className, String body) {
        var path = rootPath + "/" + packagePath + className + ".java"
        fsa.generateFile(path, generateContent(className,body))
    }

    def generateContent(String className, String body){

        return '''
            package «packageName»;

            «generateImports»

            «classType» «className» «generateImplements»{
                «body»
            }
        '''
    }

    def generateImplements() {
        if (interfaces.size == 0)
            return ""
        return '''implements «FOR i : interfaces SEPARATOR ','» «i» «ENDFOR»'''
    }
}