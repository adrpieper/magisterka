package pl.adrian.pieper.generator.builder

import java.util.List
import java.util.ArrayList
import com.sun.jmx.remote.internal.ArrayNotificationBuffer
import java.util.Arrays
import static extension pl.adrian.pieper.generator.builder.Utils.*

class ClassBodyBuilder {

    final String className
    final List<Constructor> constructors = new ArrayList
    final List<Field> fields = new ArrayList
    boolean enumInit = false;
    final List<EnumInstance> enumInstances = new ArrayList

    def withEnumInit() {
        enumInit = true;
        this
    }

    def withEnumInstance(String name,String... params) {
        enumInit = true;
        enumInstances.add(new EnumInstance(name,Arrays.asList(params)))
        this
    }

    new(String className) {
        this.className = className;
    }


    def withConstructor(Parameter... params){
        constructors.add(new Constructor(className, Arrays.asList(params)))
        this
    }

    def withField(Field field){
        fields.add(field)
        this
    }

    def withField(String type, String name, Accessor... acessors){
        withField(new Field(type, name, acessors))
    }

    def build(){
        return '''
            «enumInitCode»
            «fieldsCode»
            «constructorsCode»
            «gettersCode»
            «settersCode»
        '''
    }

    private def enumInitCode() {
        if (enumInit){
            return '''
                «FOR intance : enumInstances SEPARATOR ','»
                    «intance.code»
                «ENDFOR»
                ;
            '''
        }else{
            return "";
        }
    }

    private def fieldsCode() {

        '''
            «FOR field : fields»
                «field.declarationCode»
            «ENDFOR»
        '''
    }

    private def constructorsCode() {

        var access = if (enumInit) "" else "public"

        '''
            «FOR constructor : constructors»
                «constructor.code(access)»
            «ENDFOR»
        '''
    }

    private def gettersCode() {
        '''
            «FOR field : fields.filter([getAccessors.contains(Accessor.GETTER)])»
                «field.getterCode»
            «ENDFOR»
        '''
    }

    private def settersCode() {
        '''
            «FOR field : fields.filter([getAccessors.contains(Accessor.SETTER)])»
                «field.setterCode»
            «ENDFOR»
        '''
    }


}