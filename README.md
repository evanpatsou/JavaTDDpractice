#### Certificate
![Certificate](./certificate.jpg "Certificate")

#### What is TDD?

> "Clean code that works"
>
> ~ Ron Jeffries

So TDD is not a new idea. It's been around since 2003, and is an important part of Agile programming.
If you practise TDD, and you do it consistently and thoroughly,
then it promises to guide you to write clean code that works. Test Driven Development is a practise
that comes from Extreme Programming.Extreme Programming is a way of writing code
that complies with the Agile Manifesto. So many people associate TDD with agile,
or in other words, if you're working in an Agile way, then you should be doing TDD.

So, tests **drives** the code. Therefore, we use tests to drive the writing of our code.

In general there's a workflow which we use, which is normally described as Red, Green ,Refactor.

Red => Green => Refactor => loop

* **Red** means that we'll be writing tests of business logic, that we expect initially to fail.
* **Green** means that we'll like code or correct code so that our tests pass.
* **Refactor** means that once we have our tests passing we'll be able to refactor our code, and our test to make them more efficient.

#### What to test?

In general, we want to be writing tests that check a single identifiable piece of logic 
or behaviour. This is a unit of functionality that we want to test, hence the phrase unit 
testing. We want to test single units of functionality in isolation. So we won't be 
wanting to write tests that would check the validity of an end-to-end process, for 
example. 

Now, of course, you might want to do that for other reasons. You'd probably 
call those integration tests. But it's not part of test-driven development, and we're 
not going to be doing those in this course. Actually, looking at this, what are we going 
to test? We do need to go a little bit deeper. We're going to have multiple tests for a 
single piece of logic. Each will be testing different scenarios that are needed to make 
up this logic. Again, we'll see what this means in practise very soon. So each test 
should test one piece of logic only, and in fact, a single scenario for that piece of 
logic.

---

#### Rules of TDD

1. Test the expected outcome of an example
2. Don't pre-judge design... let your test drive it
3. Write the minimum code required to get your code
4. Each test should validate one single piece of logic.

1) When we write tests, we're thinking about the expected outcomes, not the logic, behaviour, the code,
the way we might implement it, the architecture, the design, well that list just goes on and on.
Tests generally will work on the basis of I expect this particular example
to result in the following outcomes. By using lots of tests with lots of examples,
that's how we'll know we covered all the logic that we need.

2) Part of the idea of test-driven development is that the decisions around things like data types,
class structures, and, in fact, the whole architecture of your code in general, will change over time
as you come up with tests that determine what the requirements really are.

3) If you're new to test driven development, but the idea here is that we're going to write
the minimum possible code that we can to make this test pass. We're not interested in building the correct
and full functionality at this point. Rather the minimum functionality to make this particular test pass.

4) An important aspect of test-driven development is that each test must check one single identifiable piece of logic, and only one.
Normally you'd only expect to have one assert in a test method, but there are times when you can have more than one assert.
But if you have more than one assert, it needs to fit one of the following two examples;
either you need to test more than one value to check that something worked correctly.
For example, if you expect a particular method to set three or four variables in a class,
you can perfectly validly write tests that assert each of those variables have got the correct value.
The second version is when you want to test multiple values that are just different examples of the same thing

#### Why should always start with a failed test?

If you forget the @Test annotation, you might see I got a green bar.
This test is passing. I'm fine to carry on. So, we want to always avoid that happening,
which is why we always start with a red bar. What I should have done is before the Search Force
puts a call into the Method Fail, so I know this test should always fail, I then run the test.
I can see that something's not right. I'm expecting a red bar, I spot, okay I've missed my annotation.

---

#### Best Practices

**_Test one item of functionality only_**

And this means test methods should normally have a single assert. You only use more than one assert in a test method,
if you are either testing two more examples of exactly the same thing or you need to validate more than one value
in order to know that the test has worked.

**_Test business logic, not methods_**

In a larger system, your classes may have lots and lots of methods, but you don't write the tests
to check that the methods work. You write tests to check that the business logic is correct,
so think business logic. You might need to call lots of methods in your application
in a single test to check business logic.

In other words, there will not be normally a one-to-one relationship between your tests and your methods.
If you're needing a test with the name that almost exactly matches one of your method names,
then this could be a warning that you might be forgetting to test business logic, not methods.

**_Test must be repeatable_**

This is another important point of Test Driven Development. Each time we rerun the test suite
we're not just checking that we fixed the latest test, we're also checking that the previous tests haven't broken.
So giving the same data our tests must produced the same result every single time.
To understand what we mean by this, let's consider the following test method.

**_Test must be thorough_**

There's no point only testing some of the conditions that could occur. For example, with
the ISBN validation that we were working with in the last chapter, we saw that ISBN numbers
could be 10 or 13 digits long and if they're 10 digits long, the final digit could be an 
X. To test this thoroughly, we need to check the following nine cases. Firstly, we got 
valid 10-digit ISBN numbers that don't include an X at the end and valid 10-digit numbers 
that do include an X at the end. Then we've got invalid 10-digit ISBN numbers, so that's 
numbers that look like they might be valid, but the check digit doesn't work and similarly
, with an X at the end, so there's two versions of that. And then finally, we've got 10-digit 
ISBNs that aren't numeric. Moving on the 13-digit ones well, that's a bit simpler, we've 
got valid and invalid, so that's where they check digit works or doesn't work. We've got the 
ones where 13 digits are not numeric and then finally, there's a case that any ISBN that 
is not 10 or 13 digits. So there's quite a few different cases we need to come up with to be able 
to test this and ensure that our business logic is thoroughly implemented.

So how do we come up with this list?

Well, to work out this list, I was think about the following four questions.

* Firstly, what should the logic be?
* What is the opposite to that logic?
* Are there any edge cases?
* Are there any error conditions?

---

#### JUnit Asserts

* assertTrue: check if the result of the validation is true.
* assertFalse: check if the result of the validation is false.
* assertEquals: that's used to check that two values are the same.
* assertNull and assertNotNull: check if a value is null or not.
* assertThat: This method is only available in JUnit four. It's been removed in JUnit five.
              And what you'll see is it takes two parameters. The first is the value that we want to test,
              and the second is an instance of an object that implements the Matcher interface.
              

#### JUnit two services "Set up and Tear Down"

These are both like constructor and destructor but they guarantee to run before and after every
single test in the class. Let's have a use of one of them to see how this works and because we want
some code to run before every single one of these test methods we'll use the Setup Method.

---

#### Why we want to test behaviour as well as logic

Now up until this point, we've been testing data, every test we've written has resulted us ascertain
that the value of some object matches what we expected. What we now need to do is to write test
for something slightly different. We're now going to be testing behaviour. What I want to test is which 
of these methods did or did not get called.

* Did a code behave in the way that we expected?
* Did a method we expected to run actually run?

##### Mock

A mock is similar to a stub, what we've already built here, but with a mock, you get additional features.
You get to find out whether or not a method was called. So we can write a line of code if we use a mock which says:
We assert that, in this instance, the call to the version of lookup in our database was called, but not 
the version of lookup in our web service. And in this method, we'd say that we can assert
the call to the lookup in both our database and our web service were called.
That's what we want to test and a mock allows us to do this.

**Stubs & Mocks**

|                                | Stubs | Mocks |
| :----------------------------- | :---: | :---: | 
| Override external dependencies |   X   |   X   |
| Used to test data              |   X   |       |
| Used to test behaviour         |       |   X   |

#### Mockito

**Mockito Methods**

To create an actual implementation for any of the methods, what we tell Mockito to do is say
when a particular method is called, with a particular set of parameters, this is what you should return.
And the syntax looks like this.

```
MyClass myClass = mock(MyClass.class);

// We say when this particular method is called,
// with this particular parameters,
// then you should return this particular return value.

when(myClass.myMethod(params))
    .thenReturn(return-value);
    
// The equivalent of an assert to say
// you want this method called uses the you verify method
//of Mockito and the syntax looks like this.


// If we put a one in here, we're saying
// if this method was called, with these parameters
// one times, then this is a test that passes.
// If it's called zero times or two times,
// then it's an assert that says this test should fail.

Verify(myClass, times(?))
    .myMethod(params);

Verify(myClass, atLeast(?))
    .myMethod(params);
    
Verify(myClass, atMost(?))
    .myMethod(params);
    
Verify(myClass, never())
    .myMethod(params);
```

#### Fakes and tautologies

We use stubs and mocks when the code we wish to test has some kind of external dependency
that we need to override. Both stubs and mocks are our own mini-implementations of the object that we are overriding.
The idea, then, is that stubs are used to the object to return some kind of data so that our code can execute,
and the primary use, then, of a stub is to test the outcome of the method that we are calling.
It's used to validate some form of data. Mocks, on the other hand, are used to check whether or not objects are being used.
Their purpose is to test behaviour. Now although mocks and stubs are different, in terms of their functionality using Mockito,
you can actually create a mock for every object, and in fact we'll do that shortly. We'll change the stub we built before
into a Mockito mock object. As we'll see, doing this is less effort than writing a stub in the way that we did.
In some testing frameworks, there are separate objects for mocks and stubs. If the framework you are using does provide these,
then you're generally best advised to use stubs if you're not testing behaviour, as they will be a lighter-weight option
and your tests may run a little bit faster. Mockito only gives us a single object type which is the mock
so we will create everything as a mock in Mockito.

Now you might find people refer to another object type as well as stubs and mocks,
and in particular you may come across fakes or dummies. These are even lighter-weight versions of stubs.
The use case for a fake over dummy is normally when you need to override something but you have no interest
in the thing that you're overriding. Here's a good example. Suppose that our tests call a method
which includes the following line of code.

```
logger.info("Method x called with value : " + parameter);
```

Our application is using some kind of logging system, maybe Log4j, and within the test method, it's 
calling a method of the logging system to record that the method has been called. Now that might be quite useful 
in production, but it might be annoying to have all of these method calls recorded in the log from our unit tests. 
So we might want to override this method to ensure that nothing gets written to the log when we're calling our 
unit test methods. 

Well, as I said, some frameworks provide a special object type specifically for this kind of example,
which they'd call a fake or a dummy. It's a really lightweight object which accepts any method calls. It 
doesn't ever return any data and we don't need to provide, or in fact, we can't provide any kind of 
implementation. The idea here is that, if we can override this log object with a fake or a dummy, then 
any method called to this object will simply get ignored. Well, in Mockito, you can achieve the same 
effect. You still use the mock object, but the idea is that we will create a mock, we'll insert it into the class, 
but we won't provide any kind of implementations for any of its objects. We simply create the mock and insert it in. 
And in Mockito, that effectually achieves the idea of providing a fake or a dummy.

So now this gives us three levels of objects that we could inject into our code from a unit test. 
We've got the fake or the dummy, which is when you want to override something, but you have no care about 
it at all. Its presence is just needed either to make your code work or to avoid some kind of effect 
that your code might have that doesn't impact your test, but you don't want that effect to happen somewhere 
else. And in Mockito, we do that simply by creating the mock object. We have stubs and these are used for 
when you want to override something which will impact your test, but it's not the critical parts of 
the thing that you are trying to test, and actually you're trying to test some kind of data return.
And in Mockito, we'll achieve that by creating a mock object, but giving it some kind of implementation 
with the "when, thenReturn" construct. And finally, there's the mock, where we want to know whether or not a method was 
called. And with that, we create it in Mockito by using the "mock" followed by a "verify" on the 
method that you're trying to check whether or not it has been called.

| Type | What's it for? | How to do it in Mockito       |
| :--- | :------------  | :---------------------------- | 
| Fake | No testes      | mock()                        |
| Stub | Test data      | mock() <br> when.thenReturn() |
| Mock | Test behaviour | mock() <br> verify.myMethod() |


#### How to avoid Tautologies

> A tautology is when you're using the same logic in your test as in your implementation.

So in other words, the code that we're testing is repeated in our test method.
And what that means is that if there's a mistake in this code, we might have the same mistake here,
and what we risk is getting a passing test when actually there's a mistake that we won't find.
Let's just see if this test does pass. We'll run it as a JUnit test and you get a green bar.
So this is called a tautology.

Now spotting tautologies can be a little tricky, but it's a general rule
your test should not include any logic. Remember that test should be based on examples
and expected outcomes. You shouldn't normally be calculating anything in a test. If you need to calculate something,
then it could well mean that your test isn't right and you're at the risk of having a tautology.

Code:
```
public class NumberValidator {
	public boolean isItPrime(int number) {
		int maxDivisor = (int)Math.sqrt(number); 
		for(int i=2;i<=maxDivisor;i++) {
	        if(number % i==0)
	            return false;
	    }
	    return true;
	}	
}
```

Test:
```
public class NumberValidatorTests {

    //----------------------------------------------------------------------------------------------------
    // BAD TEST
    // TAUTOLOGY
    //  which works out for each of these numbers      
    //  whether or not it's prime,      
    //  so that we can compare it to whether our isItPrime method      
    //  of the NumberValidator class also thinks it's prime,      
    //  is pretty much identical to the code      
    // within the class that we are trying to test      
    @Test
    public void checkPrimeNumbers() {

        Integer numbers[] = {1, 15, 23, 25, 60, 61, 63, 79, 207};
        NumberValidator validator = new NumberValidator();

        for (int i = 0; i < numbers.length; i++) {
            boolean isPrime = true;
            int maxDivisor = (int) Math.sqrt(numbers[i]);
            for (int counter = 2; counter < maxDivisor; counter++) {
                if (numbers[i] % counter == 0)
                    isPrime = false;
            }

            assertEquals(isPrime, validator.isItPrime(numbers[i]));

        }

    }
    
    //----------------------------------------------------------------------------------------------------
    // Correct one
    
    // We're going straight to the assert.
    // There's no calculations needed.
    //There is no risk of a tautology.
    @Test
    public void checkPrimeNumbers() {
        Integer numbers[] = {1, 23, 61, 79};

        NumberValidator validator = new NumberValidator();

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(true, validator.isItPrime(numbers[i]));
        }

    }


    @Test
    public void checkNonPrimeNumbers() {
        Integer numbers[] = {15, 25, 60, 63, 207};

        NumberValidator validator = new NumberValidator();

        for (int i = 0; i < numbers.length; i++) {
            assertEquals(false, validator.isItPrime(numbers[i]));
        }
    }
}
```

#### Using SPY

```
@Entity
public class LoanApplication {
    ..
    
    public BigDecimal getInterestRate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://loans.virtualpairprogrammers.com/getInterestRate", BigDecimal.class);
    }
    
    ...
```

Now, ideally what I would like to do is to stub this rest template object and override its get full object method
to return the value that I want which is 10%. But we've got a slight problem. And the problem is is that this rest template object
is a private variable that only exists within this method. So, there's no way for me to inject
an object to replace it. If I created a mock of this rest template, how can I inject it into this get interest rate method?
Well, there's actually no way for me to do that unless I completely re-factor this class
and make this a class level variable with a set method which I absolutely don't want to do.
I can't use the techniques we've learnt about so far to override this rest template object.
So, we need a new technique and Mockito gives us this and it's the ability to spy on an object.
Now, spying means that you don't actually replace the object. You still use the real underlying object
but you stub one or more of its methods. In other words are using spying we can replace the method of an object
but leave the rest of the object intact.

**Spy Object**

we define the class type with the annotation at spy and we instantiate it with this call to Mockitos spy method.
Now, that allows us to do the equivalent of a when then return that we saw earlier.
We can use that construct to override the methods of our loan application class.
Actually, unfortunately it's a slightly different syntax to when then return.

Rather than when then return, we have to do do return when. So, the construct looks like this.
We're going to call the do return method which is a Mockito method passing in the return value
then at the end of that we've put in a dot and a call to the when method
and then in here is the object that we are spying on and at the very end of that dot
and the underlying method name with the parameters.

```
doReturn(return_value).when(spy_object).method_call(params);
```