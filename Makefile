.PHONY: all build run clean

all: build run clean

build:
	./gradlew build --parallel

run:
	./gradlew run --parallel

clean:
	./gradlew clean --parallel

zip:
	./gradlew distZip --warning-mode all --parallel
