aspose.charset package is a container for additional charsets not supported by core java.
UTF-7 only supported at the moment.

New charsets should fulfil java.nio.charset.Charset.CharsetProvider contract so JVM will be able to
load the new charsets as an extension charsets:
1. A charset provider identifies itself with a provider-configuration file named
   java.nio.charset.spi.CharsetProvider in the resource directory META-INF/services.
2. The file should contain a list of fully-qualified concrete charset-provider class names,
   one per line. (aspose.charset.CharsetProvider in our case).
3. aspose.charset.CharsetProvider should implement java.nio.charset.spi.CharsetProvider: init and
   return all added charsets (see aspose.charset.CharsetProvider).

NOTE! Developer should take care when obfuscation this package since all classes referenced from JVM
(external non-aspose calls).