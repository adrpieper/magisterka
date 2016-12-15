package pl.adrian.pieper.generator

import java.util.List
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.eclipse.xtend.lib.annotations.Accessors

abstract class MultiClassGenerator<ItemType> implements Generator{

    @Accessors
    CommonClassGenerator common
    def Iterable<ItemType> getItems(Resource resource)
    def String getName(ItemType itemType)
    def String getBody(ItemType itemType)

    new(String packageName, String classType){
        this.common = new CommonClassGenerator(packageName,classType)
    }

    public override def doGenerate(String rootPath, Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {

        getItems(resource)
        .forEach[
            item
            |
            common.generateFile(rootPath, fsa, getName(item), getBody(item))
        ]
    }
}