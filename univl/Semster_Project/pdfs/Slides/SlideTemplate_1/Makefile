
LATEX = pdflatex

# Commands start with TAB not spaces
info:
	@echo ${LATEX}

all: Meskauskas_Presentation

Meskauskas_Presentation: Meskauskas_Presentation.tex
	${LATEX} Meskauskas_Presentation.tex > Output ; grep 'Underfull\|Overfull\|undefined on' Meskauskas_Presentation.log > Output_grep ; cat Output_grep

clean:
	rm -rf *.aux *.log *.nav *.out *.snm *.toc Output*

