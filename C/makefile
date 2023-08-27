##### folders
src_dir 	:= src
test_dir 	:= tests

##### files
src_files 	:= $(wildcard $(src_dir)/./*.c wildcard $(src_dir)/**/*.c)
obj_files 	:= $(src_files:.c=.o)

ifeq ($(OS),Windows_NT)
exec_extension := .exe
else
exec_extension := .
endif

test_src_files := $(wildcard $(test_dir)/./*Test.c wildcard $(test_dir)/**/*Test.c)
test_run_files := $(test_src_files:.c=$(exec_extension))

##### variables
CC := @gcc
CFLAGS := -g
STD := c99
C_BASE_FLAGS := -std=$(STD) -pedantic -pedantic-errors
C_BASE_FLAGS := -Werror -Wall -Wextra
C_BASE_FLAGS += -Wbad-function-cast -Wconversion -Wdeprecated -Wdiv-by-zero -Wfloat-equal -Wformat=2 -Wint-to-pointer-cast -Wjump-misses-init -Wlogical-op -Woverflow -Wpointer-to-int-cast -Wshadow -Wswitch-default

C_COMPILE_FLAGS := $(C_BASE_FLAGS) -c ${CFLAGS}

C_TEST_FLAGS := $(C_BASE_FLAGS) ${CFLAGS}

LD_FLAGS := -lcmocka

##### compile targets

all: build test

$(src_dir)/%.o: $(src_dir)/%.c
	$(CC) $(C_COMPILE_FLAGS) $< -o $@

build: ${obj_files}

##### test targets

$(test_dir)/%$(exec_extension): $(test_dir)/%.c ${obj_files}
	$(CC) $(C_TEST_FLAGS) $(filter $(src_dir)$(subst $(test_dir),,$(dir $(<)))%, ${obj_files}) $< $(LD_FLAGS) -o $@

.PHONY: test
ifeq ($(OS),Windows_NT)
test: ${test_run_files}
	@for %%x in ($(subst /,\,$(test_run_files))) do %%x || exit /b 1
else
test: ${test_run_files}
	@for exe in ${test_run_files}; do $$exe || exit 1; done
endif

##### clean targets

.PHONY: clean
ifeq ($(OS),Windows_NT)
clean:
	del /s *.o
	del /s *$(exec_extension)
else
clean:
	rm -f ${obj_files}
	rm -f $(test_dir)/*$(exec_extension)
	rm -f $(test_dir)/**/*$(exec_extension)
endif
