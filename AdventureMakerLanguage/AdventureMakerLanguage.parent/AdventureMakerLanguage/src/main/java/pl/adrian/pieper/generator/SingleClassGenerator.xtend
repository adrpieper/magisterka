package pl.adrian.pieper.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import java.util.Arrays

/**
 * Created by Adi on 2016-09-18.
 */
abstract class SingleClassGenerator{

    @Accessors
    final String className;

    @Accessors
    final String packageName;

    @Accessors
    final String classType;

    private List<String> imports = new ArrayList;
    private List<String> staticImports = new ArrayList;

    new(String className, String packageName, String classType){
        this.className = className
        this.packageName = packageName
        this.classType = classType
    }

    protected def addImports(String... imports) {

        for(String i : imports){
            this.imports.add(i);
        }
    }

    protected def addStaticImports(String... staticImports) {

        for(String i : staticImports){
            this.staticImports.add(i);
        }
    }

    public def String generateBody(Resource resource)

    public def doGenerate(String rootPath, Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

        var path =  rootPath + "/" + packageName.replaceAll("\\.","/") + "/" +  className + ".java"

        fsa.generateFile(path, generateContent(resource))
    }

    private def generateImports() {

        return '''
            «FOR imp : imports»
                import «imp»;
            «ENDFOR»
            «FOR imp : staticImports»
                import static «imp»;
            «ENDFOR»
        '''
    }

    private def generateContent(Resource resource){

        return '''
            package «packageName»;

            «generateImports»

            «classType» «className» {
                «generateBody(resource)»
            }
        '''
    }

}