using Android.App;
using Xamarin.Forms.Xaml;

[assembly: XamlCompilation(XamlCompilationOptions.Compile)]
[assembly: UsesFeature("android.harware.camera", Required = true)]
[assembly: UsesFeature("android.harware.camera.autofocus", Required = true)]