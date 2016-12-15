package pl.adrian.pieper.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext

public interface Generator {

    def void doGenerate(String rootPath, Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context)
}