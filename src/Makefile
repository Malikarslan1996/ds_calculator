# Define the directories
SRC_DIR := .
BIN_DIR := ../bin

# Define the source files and their corresponding class files
SRC_FILES := $(wildcard $(SRC_DIR)/*.java)
CLASS_FILES := $(patsubst $(SRC_DIR)/%.java,$(BIN_DIR)/%.class,$(SRC_FILES))

# Set the Java compiler and compiler flags
JAVAC := javac
JFLAGS := -d $(BIN_DIR) -cp $(BIN_DIR)

# Set the Java runtime and runtime flags
JAVA := java
JAVAFLAGS := -cp $(BIN_DIR)

# Default target to build all the class files
all: build

# Target to compile the Java source files
build: $(CLASS_FILES)

# Rule to compile a Java source file into a class file
$(BIN_DIR)/%.class: $(SRC_DIR)/%.java
	$(JAVAC) $(JFLAGS) $<


# Target to run the RMI client
run: build
	$(JAVA) $(JAVAFLAGS) CalculatorClient

# Target to clean the generated class files
clean:
	rm -rf $(BIN_DIR)/*

.PHONY: all build run clean