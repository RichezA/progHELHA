module Mood where 

data Mood = Blah | Woot deriving Show
{-
When we create our own datatypes deriving Show allows the values of that type to be print on the screen. Go check typeclasses
-}

--1. What is the type constructor, or name of this type ?
    -- Mood

--2. If the function requires a Mood value, what are the values we could possibly use ?
    -- Blah or Woot

--3. We're trying to write a function changeMood to change Chris's mood instantaneously. Should act like not in that, given one value, it returns the other one : there's the signature, what's wrong with it ?
changeMood :: Mood -> Mood 

--4. Now we want to write the function that changes his mood. based on an input mood, it gives the other one, fix the mistakes & complete the function:
    -- changeMood Mood = Woot
    -- changeMood    _ = Blah
changeMood Blah = Woot
changeMood _ = Blah