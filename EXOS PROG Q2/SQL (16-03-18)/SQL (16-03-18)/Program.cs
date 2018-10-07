using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SQL__16_03_18_
{
    class Program
    {
        static void Main(string[] args)
        {
            MainMenu();  
        }

        #region Print Menu Et Navigation Menu

        static void MainMenu()
        {
            short selectedItem = 0;
            List<string> menuItems = new List<string> { "Search by ID", "Search by last name", "Search by first name", "Search by city", "Search by phone number" };

            while (true)
            {
                Console.Clear();

                selectedItem = MenuNav(menuItems);
                WhatToDo(selectedItem);

                Console.ReadKey(true);
            };
        } 

        static short MenuNav(List<string> items)
        {
            ConsoleKeyInfo key;
            short selectedItem = 0;

            do
            {
                Console.ResetColor();
                Console.Clear();

                Console.WriteLine("Navigate with the arrow keys and select with Enter key : \n");
                Console.WriteLine("NB : The DB explorer is able to search without entering the full name of something.\nFor example, searching \"Dupond\" can be searched with \"Dup\"\n");

                for (int i = 0; i < items.Count; i++)
                {

                    if (i == selectedItem)
                    {
                        Console.BackgroundColor = ConsoleColor.DarkGray;
                        Console.ForegroundColor = ConsoleColor.White;
                    }
                    else Console.ResetColor();

                    Console.WriteLine(items[i]);
                }

                key = Console.ReadKey(true);

                switch (key.Key)
                {
                    case ConsoleKey.UpArrow:
                        if (selectedItem > 0) selectedItem--;
                        break;
                    case ConsoleKey.DownArrow:
                        if (selectedItem < (items.Count() - 1)) selectedItem++;
                        break;
                    default:
                        break;
                }

            } while (key.Key != ConsoleKey.Enter);

            return selectedItem;
        }

        static void WhatToDo(short selectedItem)
        {
            Console.ResetColor();

            switch (selectedItem)
            {
                case 0:
                    DatabaseSearch.ById();
                    break;
                case 1:
                    DatabaseSearch.ByLastName();
                    break;
                case 2:
                    DatabaseSearch.ByFirstName();
                    break;
                case 3:
                    DatabaseSearch.ByCity();
                    break;
                case 4:
                    DatabaseSearch.ByPhoneNumber();
                    break;
                default:
                    break;
            }

            
        }

        #endregion
    }
}
