INPUT = terzo-classwork.md
OUTPUT = terzo-classwork.pdf
HEADER = header.tex
PDF_ENGINE = xelatex

all: $(OUTPUT)

$(OUTPUT): $(INPUT) $(HEADER)
	pandoc $(INPUT) \
		-H $(HEADER) \
		-o $(OUTPUT) \
		--pdf-engine=$(PDF_ENGINE)

clean:
	rm -f $(OUTPUT)

.PHONY: all clean
