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
import static xsd4ld.XSDConst.* ;
import java.util.Map ;
import java.util.regex.Pattern ;

public class XSDTypeRegex {
    private static Map<String, String>  regex    = new HashMap<>() ;
    private static Map<String, Pattern> patterns = new HashMap<>() ;
    
    static {
        /* Cut-and-paste from spec, \ => \\ and wrapped as a string. */
        // short name, regex
        register(xsd_string,        null) ;
        register(xsd_decimal,       "(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)") ;
        register(xsd_integer,       "(\\+|-)?([0-9]+)") ;

        String x  = "(\\+|-)?([0-9]+(\\.[0-9]*)?|\\.[0-9]+)([Ee](\\+|-)?[0-9]+)?|(\\+|-)?INF|NaN" ;
        register(xsd_float,       x) ;
        register(xsd_double,      x) ;
        register(xsd_precisionDecimal, x) ;
        
        
        String datetimepattern =
            "-?([1-9][0-9]{3,}|0[0-9]{3})"
            +"-(0[1-9]|1[0-2])"
            +"-(0[1-9]|[12][0-9]|3[01])"
            +"T(([01][0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9](\\.[0-9]+)?|(24:00:00(\\.0+)?))"
            +"(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?" ;
        register(xsd_dateTime,       datetimepattern) ;

        // dateTimeStamp : additional:
        //'.*(Z|(\+|-)[0-9][0-9]:[0-9][0-9])'.

        register(xsd_gYear,         "-?([1-9][0-9]{3,}|0[0-9]{3})(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register(xsd_gYearMonth,    "-?([1-9][0-9]{3,}|0[0-9]{3})-(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register(xsd_gMonthDay,     "--(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register(xsd_gMonth,        "--(0[1-9]|1[0-2])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;
        register(xsd_gDay,          "---(0[1-9]|[12][0-9]|3[01])(Z|(\\+|-)((0[0-9]|1[0-3]):[0-5][0-9]|14:00))?") ;      
        register(xsd_language,      "[a-zA-Z]{1,8}(-[a-zA-Z0-9]{1,8})*") ;


        register(xsd_hexBinary,     "([0-9a-fA-F]{2})*") ;
        // Notes spaces.
        register(xsd_base64Binary,  "((([A-Za-z0-9+/] ?){4})*(([A-Za-z0-9+/] ?){3}[A-Za-z0-9+/]|([A-Za-z0-9+/] ?){2}[AEIMQUYcgkosw048] ?=|[A-Za-z0-9+/] ?[AQgw] ?= ?=))?") ;

        //anyURI
        //QName 
        
        String durationPattern =
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
                + "  )" ;
        durationPattern = durationPattern.replace(" ", "") ;                
        register(xsd_duration,              durationPattern) ;
        register(xsd_yearMonthDuration,     "-?P((([0-9]+Y)([0-9]+M)?)|([0-9]+M))") ;
        
        // duDayTimeFrag ::= (duDayFrag duTimeFrag?) | duTimeFrag
        String duTimeFrag =  
            "(T (  ([0-9]+H)([0-9]+M)?([0-9]+(\\.[0-9]+)?S)?"
            +"  | ([0-9]+M)([0-9]+(\\.[0-9]+)?S)?"
            +"  | ([0-9]+(\\.[0-9]+)?S)"
            +"  )" 
            +")" ;
        duTimeFrag = duTimeFrag.replace(" ", "") ;
            
        String dayTimePattern = "-?P((([0-9]+D)("+duTimeFrag+")?)|("+duTimeFrag+"))" ;
        register(xsd_dayTimeDuration,       dayTimePattern) ;
    }
    
    // Shortname to type
    private static Map<String, XSDDatatype> registry = new HashMap<>() ;

    private static void register(String shortName, String regex) {
        if ( regex == null )
            return ; 
        Pattern pattern = Pattern.compile(regex) ;
        patterns.put(shortName, pattern) ;        
    }
    
    /** Get the XSD regex associated with the name (stort name , not URI).
     * Maybe null.
     */
    public static Pattern getRegex(String shortName) { 
        return patterns.get(shortName) ; 
    }

    /** Get the XSD regex associated with the name (stort name , not URI).
     * Maybe null.
     */
    public static String getRegexStr(String shortName) { 
        return regex.get(shortName) ; 
    }
}

