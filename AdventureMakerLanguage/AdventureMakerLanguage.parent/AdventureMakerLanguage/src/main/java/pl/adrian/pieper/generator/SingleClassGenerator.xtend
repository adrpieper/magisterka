package pl.adrian.pieper.generator

import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtend.lib.annotations.Accessors
import java.util.List
import java.util.ArrayList
import java.util.Arrays

abstract class SingleClassGenerator implements Generator{

    @Accessors
    final String className;
    private CommonClassGenerator common;

    new(String className, String packageName, String classType){
        this.common = new CommonClassGenerator(packageName,classType)
        this.className = className
    }

    protected def addImports(String... imports) {
        common.addImports(imports)
    }

    protected def addStaticImports(String... staticImports) {
        common.addStaticImports(staticImports)
    }

    public def String generateBody(Resource resource)

    public override def doGenerate(String rootPath, Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
        common.generateFile(rootPath,fsa, className, generateBody(resource))
    }
}