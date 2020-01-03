using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Android.App;
using Android.Content;
using Android.OS;
using Android.Runtime;
using Android.Views;
using Android.Widget;
using GetYourFaceOnMyApp.Droid;
using GetYourFaceOnMyApp.MVVM;

[assembly: Xamarin.Forms.Dependency(typeof(PictureHandler))]

namespace GetYourFaceOnMyApp.Droid
{
    class PictureHandler : IPicture
    {
        public Boolean CheckForPictureIfExists(string filename)
        {
            var dir = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal);
            string name = filename + ".jpg";

            if(!File.Exists(Path.Combine(dir, name)))
            {
                return false;
            }
            else
            {
                return true;
            }
        }

        public void ClearPictures(string filename)
        {
            var dir = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal);
            string name = filename + ".jpg";
            string filePath = Path.Combine(dir, name);

            try
            {
                if (File.Exists(filePath))
                {
                    File.Delete(filePath);
                }
            }catch(IOException e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public async Task<byte[]> GetPhotoFromDisk(string filename)
        {
            var dir = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal); ;
            //var pictures = dir.AbsolutePath;
            byte[] imgData = null;

            string name = filename + ".jpg";
            string filePath = Path.Combine(dir, name);

            try
            {
                imgData = await File.ReadAllBytesAsync(filePath);
            }
            catch(Exception e)
            {
                Console.WriteLine(e.Message);
            }
            return imgData;
        }

        public async Task SavePictureToDisk(string filename, byte[] imageData)
        {
            var dir = System.Environment.GetFolderPath(System.Environment.SpecialFolder.Personal);

            string name = filename + ".jpg";
            string filePath = System.IO.Path.Combine(dir, name);

            try
            {
                await System.IO.File.WriteAllBytesAsync(filePath, imageData);

                //var mediaScanIntent = new Intent(Intent.ActionMediaScannerScanFile);
                ////mediaScanIntent.SetData(new File(filePath));
                //Xamarin.Forms.Forms.Context.SendBroadcast(mediaScanIntent);
            } catch(Exception e)
            {
                Console.WriteLine(e.ToString());
            }
        }
    }
}