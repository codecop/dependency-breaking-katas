@rem copy from path %1 and name %2 to %3
copy %1\%2 %3\
type "%~p0\_copied.md" >> %3\%2
