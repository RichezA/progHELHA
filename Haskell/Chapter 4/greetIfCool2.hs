module GreetIfCool2 where

    greetIfCool :: String -> IO()
    greetIfCool coolness = 
        if cool coolness
            then putStrLn "Hey, whassup ?"
        else
            putStrLn "Shhhhhh"
        where cool v = 
                v == "Yo man"