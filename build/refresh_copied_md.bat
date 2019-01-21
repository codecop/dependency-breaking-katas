@if exist %~n0%~x0 @cd ..



cd Java
@call "%~p0\_copy.bat" .. README.md .
cd ..



cd CSharp
cd DependencyBreakingKatas
@call "%~p0\_copy.bat" ..\.. README.md .
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\parameterise_constructor Assignment.md     ParameteriseConstructor
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\subclass_and_override Assignment.md        SubclassAndOverride
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\extract_and_override_call Assignment.md    ExtractAndOverrideCall
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\replace_global_reference Assignment.md     ReplaceGlobalReference
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\extract_and_override_factory Assignment.md ExtractAndOverrideFactory
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\extract_interface Assignment.md            ExtractInterface
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\adapt_parameter Assignment.md              AdaptParameter
cd ..\..



pause
