/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package generate;


public class Generate {
    
    static void integerTypes(IntAction action) {
        // The lexical space of some is restricted on sign and length
        // (We can assume integer and restrict on value only)
        // +0 and -0 are legal if 0 is legal.
        
        x(action, "XSD_Integer",            "integer",              "decimal",              null, null,             true) ; 
        
        x(action, "XSD_NonPositiveInteger", "nonPositiveInteger",   "integer",              null, "ZERO",             true) ;
        x(action, "XSD_NegativeInteger",    "negativeInteger",      "nonPositiveInteger",   null, "MINUS_ONE",        false) ;
        
        
        x(action, "XSD_NonNegativeInteger", "nonNegativeInteger",   "integer",              "ZERO", null,             true) ; 
        x(action, "XSD_PositiveInteger",    "positiveInteger",      "nonNegativeInteger",   "ONE", null,              false) ;

        x(action, "XSD_Long",               "long",                 "integer",              "LONG_MIN", "LONG_MAX",     true) ; 
        x(action, "XSD_Int",                "int",                  "long",                 "INT_MIN", "INT_MAX",       true) ;
        x(action, "XSD_Short",              "short",                "int",                  "i(-32768)", "i(32767)",    true) ;
        x(action, "XSD_Byte",               "byte",                 "short",                "i(-128)", "i(127)",        true) ;
        
        // "Unsigned" can still have "+123"
        x(action, "XSD_UnsignedLong",       "unsignedLong",         "nonNegativeInteger",   "ZERO", "LONG_UMAX",        true) ; 
        x(action, "XSD_UnsignedInt",        "unsignedInt",          "unsignedLong",         "ZERO", "INT_UMAX",         true) ; 
        x(action, "XSD_UnsignedShort",      "unsignedShort",        "unsignedInt",          "ZERO", "i(65535)",         true) ; 
        x(action, "XSD_UnsignedByte",       "unsignedByte",         "unsignedShort",        "ZERO", "i(255)",           true) ;
    }
    
    static class IntegerDesc {
        public IntegerDesc(String className, String shortName, String baseType, 
                           String minValue, String maxValue) {
            super() ;
            this.className = className ;
            this.shortName = shortName ;
            this.baseType = baseType ;
            this.minValue = minValue ;
            this.maxValue = maxValue ;
        }
        String className ;
        String shortName ;
        String baseType;
        String minValue;
        String maxValue;
    }
    
    /**
     * 
     * @param className
     * @param shortName
     * @param baseType
     * @param minValue
     * @param maxValue
     * @param allowZero
     */
    private static void x(IntAction action, String className, String shortName, String baseType, String minValue, String maxValue, boolean allowZero) {
        IntegerDesc idesc = new IntegerDesc(className, shortName, baseType, minValue, maxValue) ;
        action.action(idesc);
    }

    @FunctionalInterface
    interface IntAction { void action(IntegerDesc desc) ; }
    
    public static void main(String[] args) {
        datetimeTypes();
    }
    
    public static void integerTypes(String[] args) {
        // Generate integer inner classes 
        integerTypes(desc->{
            System.out.println("    public static class "+desc.className+" extends BaseInteger {") ;
            System.out.println("        "+desc.className+"() {") ;
            System.out.println("            super(\""+desc.shortName+"\", \""+desc.baseType+"\", "+desc.minValue+", "+desc.maxValue+") ;") ;
            System.out.println("        }") ;
            System.out.println("    }") ;
            System.out.println() ;
        }) ;
    }

    
    static void datetimeTypes() {
        //y("dateTimeStamp", 
        y("dateTime") ;
        y("time") ;
        y("date") ;
        y("gYearMonth") ;
        y("gYear") ;
        y("gMonthDay") ;
        y("gDay") ;
        y("gMonth") ;
    }


    private static void y(String string) {
        String string2 = Character.toUpperCase(string.charAt(0))+string.substring(1) ;
        String cls = "XSD_"+string2 ;
        
        String parser = "parse"+string2 ;
        
        System.out.println("    public static class "+cls+" extends BaseDateTime {") ;
        System.out.println("        public "+cls+"() {") ;
        System.out.println("            super(\""+string+"\", DateTimeStruct::parse"+string2+") ;") ;
        System.out.println("        }") ;
        System.out.println("    }") ;
    }
}

