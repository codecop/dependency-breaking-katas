@if exist %~n0%~x0 @cd ..



cd Java
@call "%~p0\_copy.bat" .. README.md .
cd ..



cd CSharp
cd DependencyBreakingKatas
@call "%~p0\_copy.bat" ..\.. README.md .
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\a Assignment.md ParameteriseConstructor
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\b Assignment.md SubclassAndOverride
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\c Assignment.md ExtractAndOverrideCall
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\d Assignment.md ReplaceGlobalReference
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\e Assignment.md ExtractAndOverrideFactory
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\f Assignment.md ExtractInterface
@call "%~p0\_copy.bat" ..\..\Java\src\main\java\org\codecop\dependencies\g Assignment.md AdaptParameter
cd ..\..



pause
