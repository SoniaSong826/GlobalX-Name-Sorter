# Name Sorter
Given a set of names, this program order that set first by last name, then by any given names the person may have. Read name list from the input `.txt` file assigned by command line, and write an output `.txt` file to the current folder.

**Name valid rule**: A name must have at least 1 given name and may have up to 3 given names. For example, `Ashish Hunter Uriah Mathew Clarke` and `Peter` are invalid.

## Usage

cd to `./target/classes` folder and then execute the program in the following way (Please make sure a input file exists):
```
java NameSorter ./<input-file-name.txt>
```

## Example
Unsorted Name List:
```
Janet Parsons
Vaughn Lewis
Adonis Julius Archer
Shelby Nathan Yoder
Marin Alvarez
London Lindsey
Beau Tristan Bentley
Leo Gardner
Hunter Uriah Mathew Clarke
Mikayla Lopez
Frankie Conner Ritter
```
Sorted Result:
```
Marin Alvarez
Adonis Julius Archer
Beau Tristan Bentley
Hunter Uriah Mathew Clarke
Leo Gardner
Vaughn Lewis
London Lindsey
Mikayla Lopez
Janet Parsons
Frankie Conner Ritter
Shelby Nathan Yoder
```

## Invalid Names
When meeting invalid names in input file, the program keeps running and write the line number of invalid names to console.
```
Error at line 6, name: Peter should have 1 family name, at least 1 given name and may have up to 3 given names
```

## Sorting Assumptions
1. First compare family name.

2. Then compare given names character by character with whitespaces if existing.

**Note that**: When given name has more than one fields (e.g. Adonis Julius Archer)
           First name and other middle names are treated as given names.
           No precedences for them when comparing.
           
[Name Fields Defination Reference](https://immi.homeaffairs.gov.au/help-text/eplus/Pages/elp-h0010.aspx)

## Unit Test
Use **JUnit** framework for unit tests. 

Coverage report:

**Overall**: 100% classes and 85% lines covered.

- Name Class: 100% classes and 94% lines covered.
- NameSorter Class: 100% classes and 80% lines covered.
