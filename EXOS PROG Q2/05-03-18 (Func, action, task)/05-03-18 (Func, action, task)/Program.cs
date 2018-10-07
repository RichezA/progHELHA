using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _05_03_18__Func__action__task_
{
    class Program
    {
        static void Main(string[] args)
        {
            float valeur1 = 25.0F;
            int a = 5, b = 25;

            #region Func

            Func<float, int> func = new Func<float, int>((val) => { return (int)(val + 25.0F); });

            Console.WriteLine(func(valeur1));

            #endregion

            Console.Write("\n");

            #region Action

            Action<int, int> Addition = new Action<int, int>((y, z) => { Console.WriteLine(a + b); });

            Addition(a, b);

            #endregion

            Console.ReadKey(true);
            Console.ReadKey(true);
        }
    }
}
