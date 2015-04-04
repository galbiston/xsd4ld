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

import org.junit.Test ;

/** Test of the machinary for strings and derived types.
 * @see TestIntegerRange
 */
public class TestString {
    @Test public void string_01() { LibTestXSD.valid("abc", XSD.xsdString); }  
    @Test public void string_02() { LibTestXSD.valid("\t", XSD.xsdString); }
    
    @Test public void normalizedString_01() { LibTestXSD.valid("abc", XSD.xsdNormalizedString) ; }
    @Test public void normalizedString_02() { LibTestXSD.invalid("\t", XSD.xsdNormalizedString) ; }
    @Test public void normalizedString_03() { LibTestXSD.invalid("abc\n", XSD.xsdNormalizedString) ; }
    @Test public void normalizedString_04() { LibTestXSD.invalid("\rdef", XSD.xsdNormalizedString) ; }
    
    // @@ Token
    // @@ Language
}

