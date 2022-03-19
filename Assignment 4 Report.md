**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \:  35     |            |
|-------------------|------------|
| Student Names:    |    UCID    |
| Luis Sulbaran     | 30090906   |
| Adam Abouelhassan | 30087777   |
| Jaxson Waterstreet| 30095706   |  
| Sadia Khan        | 30090271   |

# Introduction

The objective of this lab was to implement mutation testing to our assignment 3 test cases for Range and DataUtilities to improve the quality and completeness of our test suite. Using PIT test, our source code was injected with mutants and analyzed for mutation coverage. The second objective of this lab was to utilize GUI testing tools to test one of the given websites. We used Selenium to record and replay GUI test scripts.

# Analysis of 10 Mutants of the Range class 

**1. Mutation on Line 95: Decremented (a--) double local variable 1 -> SURVIVED**

The mutation is involved in the Range constructor method which changes the line: this.lower = lower--;

Since this is a post-decrement operation, the value this.lower will contain the original value of lower, but will decrement the value of the variable after executing the expression which doesn’t affect our program so our test cases do not kill it.

**2. Mutation on Line 144: greater than to less or equal -> KILLED**

The mutation is involved in the contains(double value) method which changes the line:
return (value >= this.lower && value <= this.upper) to return (value <= this.lower && value <= this.upper).

In one of our test cases for this method, we had a Range from (-1,1) that would contain the number 0.9. Our test case would successfully return true in this case because 0.9 is greater than or equal to -1. However, with the mutant, this would be false. For this reason, since we did not get the expected output of true, our test case was able to kill the mutant.

**3. Mutation on Line 132: Replaced double addition with subtraction -> KILLED**

The mutation is involved in the getCentralValue() method which changes the line:
return this.lower/2.0 + this.upper/2.0 to return this.lower/2.0 - return this.upper/2.0.

In one of our test cases for this method we had a Range from (0,0), the outcome of the central value would not change if the signs were changed, killing the mutant. For any other of our test cases our mutant would have survived as the outcome of the central values would have changed if it was + and -.

**4. Mutation on Line 90: removed conditional - replaced comparison check with false -> SURVIVED**

The mutation is involved in the Range(double lower, double upper) method which changes the comparison check with false.

When creating Ranges for our testing we did not create a range where our upper was greater than our lower, other than our (0,0) range. For this reason, the mutant survives as the range(0,0) evaluates correctly regardless of the condition.

**5. Mutation on Line 105: Negated double field lower -> KILLED**

The mutation is involved in the getLowerBound() method which negates the original value of the lower bound in our range.

For a range that we used such as Range(-100.0, 200.0), the getLowerBound successfully returned the value of -100.0. With the mutant, this value was changed to its negation, 100, which caused the returned value to be opposite of what was expected, failing the test and killing the mutant.

**6. Mutation on Line 144: Substituted 1 with -1 -> SURVIVED**

The mutation is involved in the contains(double value) method which changes the returns a true return value to false. 

This mutant survived because our test cases were not sufficient in considering these extensive cases.

**7. Mutation on Line 224: Removed call to org/jfree/data/Range::getUpperBound -> KILLED**

The mutation is involved in the combine(Range range1, Range range2) method which calls the getUpperBound method to receive the upper bound of the range.

The mutation is killed as it tries to call the method to compare with another value but since it removed the call to the method, it is comparing to something that doesn’t exist so the test fails and the mutant is killed.

**8. Mutation on Line 132: Incremented (a++) double field lower -> SURVIVED**

The mutation is involved in the Range constructor method which changes the line: return this.lower/2.0 + this.upper/2.0 to return this.lower++/2.0 + this.upper/2.0.

Since this is a post-increment operation, the value this.lower will contain the original value of lower, but will increment the value of the variable after executing the expression which doesn’t affect our program so our test cases do not kill it.

**9. Mutation on Line 90: Incremented (++a) double local variable number 1 -> KILLED**

The mutation is involved in the Range(double lower, doubleupper) constructor method which increments the lower value to ++lower in the conditional statement.

Since this is a pre-increment operation, the output is not as expected thus the test fails and the mutant is killed.

**10. Mutation on Line 303: Replaced return value with null for org/jfree/data/Range::expandToInclude -> KILLED**

The mutation is involved in the expandToInclude(Range range1, double value) which replaces the line return new Range(value, value) to return null.

In our test suite, we have covered this scenario where the test case expects that the code returns a non-null range for a given value. Therefore, when this mutant is executed it fails as expected.

# Report all the statistics and the mutation score for each test class



# Analysis drawn on the effectiveness of each of the test classes


# A discussion on the effect of equivalent mutants on mutation score accuracy

Equivalent mutants will negatively affect mutation score and will decrease the accuracy of mutation score as they will produce the same output as the original program and survive mutant testing. This issue will make it quite hard to obtain a mutant score of 100% one must take this fact into consideration when evaluating mutant scores. Equivalent mutants can often be found in loop conditions and post incrementing a value which is not used again in code. There can be other equivalent mutants as well, one has to look for mutants that are syntactically different  but semantically the same to find equivalent mutants.

# A discussion of what could have been done to improve the mutation score of the test suites

To improve our mutation score of the test suites, we analysed the initial mutation score and made note of the mutants that survived the PIT test. After analysis of these mutants we were able to come up with new test cases which would kill the surviving mutants. We focused mainly on one function at a time trying to kill as many mutants as possible for that specific function. Once we felt enough mutants were killed, we moved to another function.

# Why do we need mutation testing? Advantages and disadvantages of mutation testing

Mutation testing has many advantages that increase the overall quality of test suites. It protects a program from potential bugs by checking if the test suite is strong enough to kill injected faults. Mutants can be automated, which makes it easier to use mutation testing on a test suite. The more bugs that are detected, the better the the test suite is. This fault-based testing approach improves the completeness and quality of the test suite. However, mutation testing also has its disadvantages. The execution and analysis time is extremely slow for automated mutation testing tools, as we have seen first hand from using PIT test. Also, mutation testing cannot be used alongside black box tsting since access to the source code is required in order to inject mutants. 


# Explain your SELENUIM test case design process

When coming up with our test cases on selenium, we tried to test each of the major features of the best buy website to ensure functionality of the website. Once each group member chose a functionality of the website we used selenium to record the process of us using the specified functionality. After creating the test suite we ran our tests to ensure the tests would pass. 

# Use of Assertions and Checkpoints

Verification points are an important aspect of GUI. These verification points allow the tests to check partway to verify that the test is running as it should. This can be done by testing what page the site is currently on or the contents of the current page. This can allow a tester to save time as there is no reason for the test to continue running if it is not on the correct page or incorrect items are missing. Our group decided to not use verification points as the majority of our tests were quite simple and quick so the application of verification points was not an efficient use of our time.

# Testing each Functionaity with Different Test Data

When creating our GUI tests, we tried to cover a wide range of common functionalities users come across while using the Best Buy website. Each functionality was tested with different data sets to ensure they work correctly.

## Functionalities Tested
1. Login
2. Creating an account
3. Adding to cart
4. Using the search bar
5. Using the menu
6. Using the filters
7. Finding stores
8. Viewing deals

## Different Test Data

Login:
- Login with valid credentials
- Login with invalid credentials (incorrect email and password)

Creating an account:
- Create an account with valid credentials
- Create an account with invalid credentials (wrong password)

Adding to cart:
- Adding a TV to cart
- Adding a monitor to cart

Using the search bar:
- Search for an LG dishwasher
- Search for an iPhone
- Search for SD card

Using the menu:
- Browse headphones
- Browse mouse and keyboards

Using the filters:
- Filter high to low
- Filter by On Sale

Finding stores:
- Find stores in Calgary
- Find stores in Alberta

Viewing deals:
- View spring deals
- View top selling products

# Advantages and Disadvantages of Selenium & Sikulix
## Selenium

Advantages:
- User-friendly interface, simple and very easy to use
- Allows you to replay the sequence of steps of the test script

Disadvantages:
- Slow performance and caused webpages to become unresponsive

## Sikulix

Advantages
- Image recognition makes it easy to test specific elements of a webpage
- Automates flash objects, while Selenium does not

Disadvantages:
- Having to manually write the test scripts
- User interface is not as friendly as Selenium


# How the team work/effort was divided and managed

The work for the mutation testing was done in 2 groups - Sadia and Luis on Range, and Adam and Jaxson on DataUtilities. Each group made test cases to ensure that the mutation coverage was 10% higher than the original suite. We all met up afterwards to go over the new test suites and how they improved from the last. For the GUI Testing, each person was responsible for 2 different functionalities for the Best Buy website. We all recorded our scripts and reviewed them with one another to ensure we all the functionalities we had proposed in our test plan. Once the main part of the lab was done, we moved to the lab report. The lab report was divided into sections and assigned to each group member. Each group member was responsible for a few sections of the lab report and had to complete their sections by the day before the submission deadline, in order for the group to meet and look over each section. Each section was approved by all the group members before submitting the report. 

# Difficulties encountered, challenges overcome, and lessons learned

Working with PIT Test was quite challenging due to the issue with setting this lab up. Once it was fixed, the only other issues that were encountered was the amount of time that it required for PIT test to execute the mutation tests. Lessons that we learnt from these teamwork activities is that it is much easier and faster to bounce ideas off of each other in terms of understanding the mutation tests and how we could improve them.

# Comments/feedback on the lab itself

Since setting up the lab was a bit challenging, clearer instructions should be provided in the future. 
