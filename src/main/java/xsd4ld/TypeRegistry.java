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

package xsd4ld;

import java.util.HashMap ;
import java.util.Map ;
import java.util.regex.Pattern ;

public class TypeRegistry {
 private static Map<String, String>  regex    = new HashMap<>() ;
 private static Map<String, Pattern> patterns = new HashMap<>() ;
    
    static {
        // short name, regex
        register("string",      null) ;
        register("decimal",     "(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)") ;
        register("integer",        "(\\+|-)?([0-9]+)") ;
        register("float",       "(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([Ee](\\+|-)?[0-9]+)?|(\\+|-)?INF|NaN") ;
        register("double",      "(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([Ee](\\+|-)?[0-9]+)? |(\\+|-)?INF|NaN") ;
        
        // dateTime
        /* Cut-and-paste from spec, \ => \\ and wrapped as a string. */
        String datetimepattern =
            "-?([1-9][0-9]{3,}|0[0-9]{3})"
            +"-(0[1-9]|1[0-2])"
            +"-(0[1-9]|[12][0-9]|3[01])"
            +"T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))"
            +"(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?".replace(" ", "") ;
        register("dateTime",       datetimepattern) ;

        // dateTimeStamp : additional:
        //'.*(Z|(\+|-)[0-9][0-9]:[0-9][0-9])'.
        

        register("gYear",       "-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register("gYearMonth",  "-?([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register("gMonthDay",   "--(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register("gMonth",      "--(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register("gDay",        "---(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;      

        register("hexBinary",   "([0-9a-fA-F]{2})*") ;
        register("base64Binary", "((([A-Za-z0-9+/] ?){4})*(([A-Za-z0-9+/] ?){3}[A-Za-z0-9+/]|([A-Za-z0-9+/] ?){2}[AEIMQUYcgkosw048] ?=|[A-Za-z0-9+/] ?[AQgw] ?= ?=))?") ;

        //anyURI
        //QName 

        // Simple duration.
        // -?P[0-9]+Y?([0-9]+M)?([0-9]+D)?(T([0-9]+H)?([0-9]+M)?([0-9]+(\.[0-9]+)?S)?)?
        // '.*[YMDHS].*'
        // '.*[^T]' 
        
        /* Cut-and-paste from spec, \ => \\ and wrapped as a string. */
        String durationpattern =
            "-?P( ( ( [0-9]+Y([0-9]+M)?([0-9]+D)?"
                + "       | ([0-9]+M)([0-9]+D)?"
                + "       | ([0-9]+D)"
                + "       )"
                + "       (T ( ([0-9]+H)([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?"
                + "          | ([0-9]+M)([0-9]+(\\.[0-9]+)?S)?"
                + "          | ([0-9]+(\\.[0-9]+)?S)"
                + "          )"
                + "       )?"
                + "    )"
                + "  | (T ( ([0-9]+H)([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?"
                + "       | ([0-9]+M)([0-9]+(\\.[0-9]+)?S)?"
                + "       | ([0-9]+(\\.[0-9]+)?S)"
                + "       )"
                + "    )"
                + "  )".replace(" ", "") ;
        register("duration",       durationpattern) ;

        
        register("language",        "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*") ;
        
        
        /* yearMonthDuration
         * But duration + checking is better?
        '-?P((([0-9]+Y)([0-9]+M)?)|([0-9]+M))' or the expression '-?P[0-9]+(Y([0-9]+M)?|M)'
        ie. additonal'[^DT]*'
        */
        /*
          Additonal: '[^YM]*[DT].*'
          
         */
    }
    
    // Shortname to type
    public static Map<String, XSDDatatype> registry = new HashMap<>() ;
    static {
//        static public XSD_Simple             xsdSimple             = R1.xsdSimple ;
//        static public XSD_Atomic             xsdAtomic             = R1.xsdAtomic ;
//
//        static public XSD_Decimal            xsdDecimal            = R1.xsdDecimal ;
//        static public XSD_Integer            xsdInteger            = R1.xsdInteger ;
//
//        static public XSD_Long               xsdLong               = R1.xsdLong ;
//        static public XSD_Int                xsdInt                = R1.xsdInt ;
//        static public XSD_Short              xsdShort              = R1.xsdShort ;
//        static public XSD_Byte               xsdByte               = R1.xsdByte ;
//
//        static public XSD_NegativeInteger    xsdNegativeInteger    = R1.xsdNegativeInteger ;
//        static public XSD_NonNegativeInteger xsdNonNegativeInteger = R1.xsdNonNegativeInteger ;
//        static public XSD_NonPositiveInteger xsdNonPositiveInteger = R1.xsdNonPositiveInteger ;
//        static public XSD_PositiveInteger    xsdPositiveInteger    = R1.xsdPositiveInteger ;
//
//        static public XSD_UnsignedLong       xsdUnsignedLong       = R1.xsdUnsignedLong ;
//        static public XSD_UnsignedInt        xsdUnsignedInt        = R1.xsdUnsignedInt ;
//        static public XSD_UnsignedShort      xsdUnsignedShort      = R1.xsdUnsignedShort ;
//        static public XSD_UnsignedByte       xsdUnsignedByte       = R1.xsdUnsignedByte ;
//
//        static public XSD_DateTimeStamp      xsdDateTimeStamp      = R1.xsdDateTimeStamp ;
//        static public XSD_DateTime           xsdDateTime           = R1.xsdDateTime ;
//        static public XSD_Date               xsdDate               = R1.xsdDate ;
//        static public XSD_Time               xsdTime               = R1.xsdTime ;
//
//        static public XSD_GYear              xsdGYear              = R1.xsdGYear ;
//        static public XSD_GYearMonth         xsdGYearMonth         = R1.xsdGYearMonth ;
//        static public XSD_GMonthDay          xsdGMonthDay          = R1.xsdGMonthDay ;
//        static public XSD_GDay               xsdGDay               = R1.xsdGDay ;
//        static public XSD_GMonth             xsdGMonth             = R1.xsdGMonth ;

    }
    
    
    
    
    public static void register(String shortName, String regex) {
        patterns.put(shortName, Pattern.compile(regex)) ;        
    }
    
    public static Pattern getRegex(String shortName) { 
        return patterns.get(shortName) ; 
    }

    public static String getRegexStr(String shortName) { 
        return regex.get(shortName) ; 
    }
}

