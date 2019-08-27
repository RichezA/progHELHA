using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Data.Sql;
using System.Threading;
using System.Data;

namespace Linq_to_SQL_Older_techniques__19_03_18_
{
    class Program
    {
        static void Main(string[] args)
        {
            string myConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=TestDatabase;Persist Security Info=True;User ID=User;Password=pass";
            SqlConnection myConnect = new SqlConnection(myConnectionString);
            DataSet dataSet = new DataSet();
            dataSet.Tables.Add("Clients2");

            SqlCommand deleteCommand = new SqlCommand();

            while (true)
            {
                Console.Clear();

                try
                {
                    myConnect.Open();

                    Console.WriteLine("Connexion en cours...");

                    if (myConnect.State == System.Data.ConnectionState.Open)
                    {
                        Console.WriteLine("Connexion établie.");

                        SqlCommand myCommand = new SqlCommand();
                        myCommand.Connection = myConnect;
                        myCommand.CommandType = System.Data.CommandType.Text;

                        deleteCommand.Connection = myConnect;
                        deleteCommand.CommandType = CommandType.Text;

                        //AccessData(myCommand);
                        //AccessData2(myCommand, dataSet);
                        DeleteData(deleteCommand);

                        myConnect.Close();
                    }
                    else throw new Exception("Impossible d'établir la connection...");
                }
                catch (Exception ex) { Console.WriteLine(ex.Message); }
                finally { Console.ReadKey(true); }
            }
        }


        static void AccessData(SqlCommand sqlCommand)
        {
            bool exit = false;
            string command = null;

            List<string> dataReceived = new List<string>();

            command = Console.ReadLine();
            sqlCommand.CommandText = command;
            SqlDataReader dataReader = sqlCommand.ExecuteReader();

            //Mode Connecté :
            while (dataReader.Read()) dataReceived.Add(dataReader["Nom"].ToString());

            Console.WriteLine();

            foreach (var item in dataReceived) Console.WriteLine(item);

            dataReader.Close(); //!!!!!!

        }

        static void AccessData2(SqlCommand sqlCommand, DataSet dataSet)
        {
            sqlCommand.CommandText = "select * from Clients2";
            SqlDataReader dataReader = sqlCommand.ExecuteReader();

            dataSet.Tables[0].Load(dataReader);

            foreach (DataRow client in dataSet.Tables[0].Rows)
            {
                Console.WriteLine(client["Nom"]);
            }
            Console.ReadKey(true);
        }

        static void DeleteData(SqlCommand deleteCommand)
        {
            deleteCommand.CommandText = "delete from Clients2 where nom like 'Duelz'";
            deleteCommand.ExecuteNonQuery();

            Console.WriteLine("Utilisateurs aux noms \"Duelz\" supprimés");
        }
    }
}
