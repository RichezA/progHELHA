using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data;
using System.Data.SqlClient;

namespace _23_03_18_SQL
{
    class Program
    {
        static void Main(string[] args)
        {
            string nom = null;

            DataSet1 myDataset = new DataSet1();
            DataSet1.ClientRow test = myDataset.Client.NewClientRow();

            test.Nom = "Dupond";
            test.Prenom = "Jean-Jacques";
            test.idClient = new Guid();

            myDataset.Client.Rows.Add(test);



            string myConnectionString = @"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=TestDatabase;Persist Security Info=True;User ID=User;Password=pass";
            SqlConnection myConnection = new SqlConnection(myConnectionString);
            SqlCommand selectClient = new SqlCommand();

            selectClient.Connection = myConnection;
            selectClient.CommandType = CommandType.Text;

            try
            {
                myConnection.Open();

                if(myConnection.State == ConnectionState.Open)
                {
                    Console.WriteLine("Connexion établie");
                    Console.Write("\nIntroduire le nom du client à rechercher : ");

                    nom = Console.ReadLine();

                    selectClient.CommandText = "select * from Clients2 where nom like '" + nom + "'";

                    SqlDataReader dataReader = selectClient.ExecuteReader();

                    if (dataReader.HasRows)
                    {
                        Console.WriteLine("Enregistrements trouvés");

                        while (dataReader.Read()) Console.WriteLine(dataReader["nom"] + " " + dataReader["prenom"]);
                    }
                    else Console.WriteLine("Aucun enregistrement à ce nom");

                    dataReader.Close();
                    myConnection.Close();
                }
            }
            catch (Exception ex) { Console.WriteLine(ex.Message); }

            Console.ReadKey(true);
        }
    }
}
