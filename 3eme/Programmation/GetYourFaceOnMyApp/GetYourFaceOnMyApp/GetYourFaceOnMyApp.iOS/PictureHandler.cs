using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Foundation;
using GetYourFaceOnMyApp.iOS;
using GetYourFaceOnMyApp.MVVM;
using UIKit;

[assembly: Xamarin.Forms.Dependency(typeof(PictureHandler))]

namespace GetYourFaceOnMyApp.iOS
{
    class PictureHandler : IPicture
    {
        public bool CheckForPictureIfExists(string filename)
        {
            throw new NotImplementedException();
        }

        public Task ClearPictures(string path)
        {
            throw new NotImplementedException();
        }

        public byte[] GetPhotoFromDisk(string filename)
        {
            //var imgData = 
            throw new NotImplementedException();
        }

        public void SavePictureToDisk(string filename, byte[] imageData)
        {
            var image = new UIImage(NSData.FromArray(imageData));
            image.SaveToPhotosAlbum((img, error) =>
            {
                // photo can be retrieved with
                // var i = img as UIImage;
                if(error != null)
                {
                    Console.WriteLine(error.ToString());
                }
            });
        }

        Task<byte[]> IPicture.GetPhotoFromDisk(string filename)
        {
            throw new NotImplementedException();
        }

        Task IPicture.SavePictureToDisk(string filename, byte[] imageData)
        {
            throw new NotImplementedException();
        }
    }
}