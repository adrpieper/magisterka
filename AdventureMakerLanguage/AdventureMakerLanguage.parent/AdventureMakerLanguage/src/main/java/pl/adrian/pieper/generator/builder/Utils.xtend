package pl.adrian.pieper.generator.builder

class Utils {

    static def declarationCode(Field field) {
        return '''
            private «field.type» «field.name»;
        '''
    }

    static def getterCode(Field field) {
        return '''
            public «field.type» get«field.name.toFirstUpper»() {
                return «field.name»;
            }
        '''
    }

    static def setterCode(Field field) {
        return '''
            public set«field.name.toFirstUpper»(«field.type» «field.name») {
                this.«field.name» = «field.name»;
            }
        '''
    }

    static def code(Constructor constructor, String access) {
        return '''
            «access» «constructor.className» («FOR param : constructor.params SEPARATOR ','» «param.getType» «param.getName» «ENDFOR») {
                «FOR param : constructor.params»
                    this.«param.getName» = «param.getName»;
                «ENDFOR»
            }
            
        '''  
    }

    static def code(EnumInstance instance) {
        '''
        «instance.name»(«FOR param : instance.params SEPARATOR ','»«param»«ENDFOR»)
        '''
    }
}