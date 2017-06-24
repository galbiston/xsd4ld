/*
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

package langtag;

import java.util.IllformedLocaleException;
import java.util.Locale;

public class DevLangTag {
    
    public static void main(String...a) {
        try { 
            Locale.Builder locBuild = new Locale.Builder();
            //locBuild.setLanguageTag("de-CH-x-phonebk");
            locBuild.setLanguageTag("zh-cn-a-myext-x-private");
            Locale lc = locBuild.build();
            System.out.println("L:"+lc.getLanguage());
            System.out.println("S:"+lc.getScript());
            System.out.println("C:"+lc.getCountry());
            System.out.println("V:"+lc.getVariant());
            System.out.println(lc.toLanguageTag());
            
            LangTag lang3 = LangTagParser.parse("zh-cn-a-myext-x-private") ;
            System.out.println();
            System.out.println(lang3.asString());
            
            LangTag lang2 = LangTagParserAlt.parse("zh-cn-a-myext-x-private") ;
            System.out.println();
            System.out.println(lang2.asString());
            
            
            
        } catch (IllformedLocaleException ex) {
            ex.printStackTrace();
        }
    }
    

}
