XSD4LD is a package to handle the atomic XSD datatypes (except those
specific to XML). It provides validation and production of values for valid
lexical forms.

License: Apache License v2

Notes:

* Whitespace is not allowed around lexical forms that do not 
  include whitespace in their valid inputs.

* "INF", as per spec, not "Infinity" as found in Java.

Mapping to Java: 

As for javax.util.xml 

* Precision decimal maps to BigDecimal except when it's a Nan or INF
  when it is mapped to a Double.
