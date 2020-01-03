using System;
using System.Collections.Generic;
using System.IO;
using System.Net;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using GetYourFaceOnMyApp.MVVM;
using Newtonsoft.Json;
using Xamarin.Essentials;
using Xamarin.Forms;

namespace GetYourFaceOnMyApp.MVVM
{
    public class UserClientHttp
    {
        private HttpClient client;
        private String apiURL;

        public UserClientHttp(String apiURL = "https://reqres.in/api/users?page=1")
        {
            this.client = new HttpClient();
            this.apiURL = apiURL;
        }

        public async Task<UserList> GetUsers()
        {
            UserList tempUserList;
            HttpResponseMessage response = await client.GetAsync(this.apiURL);


            if (response.IsSuccessStatusCode)
            {
                tempUserList = await response.Content.ReadAsAsync<UserList>();
                foreach (var user in tempUserList.data)
                {
                    if (!checkForImageIfExists(user.id.ToString()))
                        await getImageFromUri(user.avatar, user.id.ToString());
                }
                return tempUserList;
            }

            throw new NotImplementedException();
        }

        private Boolean checkForImageIfExists(String id)
        {
            return DependencyService.Get<IPicture>().CheckForPictureIfExists(id);
        }

        public async Task getImageFromUri(String uri, String filename)
        {
            ImageSource imgSrc = null;

            byte[] imageBytes = await getImage(uri);
            await DependencyService.Get<IPicture>().SavePictureToDisk(filename, imageBytes);

            // Saving image
                

            //imgSrc = ImageSource.FromStream(() => new MemoryStream(imageBytes));
            //return imgSrc;
        }

        private async Task<byte[]> getImage(String uri)
        {
            WebClient webClient = new WebClient();

            byte[] imageBytes = await webClient.DownloadDataTaskAsync(uri);
            return imageBytes;
        }

        public async Task<ImageSource> GetLocalPicture(String id)
        {
            var imageBytes = await DependencyService.Get<IPicture>().GetPhotoFromDisk(id);
            if (imageBytes != null)
                return ImageSource.FromStream(() => new MemoryStream(imageBytes));
            else throw new Exception();
        }

        public void DeletePic(string id)
        {
            DependencyService.Get<IPicture>().ClearPictures(id);
        }


        //public async Task GetUsers(Action<IEnumerable<User>> action)
        //{
        //    HttpResponseMessage response = await client.GetAsync(this.apiURL);


        //    if (response.IsSuccessStatusCode)
        //    {
        //        var tempUserList = JsonConvert.DeserializeObject<UserList>(await response.Content.ReadAsStringAsync());
        //        var tempList = tempUserList.data;
        //        action(tempList);
        //    }

        //    throw new NotImplementedException();
        //}
    }
}
