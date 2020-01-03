using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace GetYourFaceOnMyApp.MVVM
{
    public interface IPicture
    {
        Task SavePictureToDisk(string filename, byte[] imageData);
        Task<byte[]> GetPhotoFromDisk(string filename);
        Boolean CheckForPictureIfExists(string filename);
        void ClearPictures(string filename);
    }
}
