using ExoAuthentificationASP.Models;
using System;
using System.Collections.Generic;
using System.Drawing;
using System.Drawing.Drawing2D;
using System.Drawing.Text;
using System.IO;
using System.Linq;
using System.Text;
using System.Web;
using System.Web.Mvc;
using System.Web.Services.Description;

namespace ExoAuthentificationASP.Controllers
{
    public class HomeController : Controller
    {
        // GET: Home
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult NotFound(string aspxerrorpath)
        {
            //ViewBag.Error = aspxerrorpath;
            return View();
        }

        public ActionResult Unauthorize()
        {
            return View();
        }

        public ActionResult Index2()
        {
            //ViewBag.Error.IsError = true;
            //ViewBag.Error.Message = "Je suis fatigué";
            return View();
        }

        public ActionResult Index3()
        {
            throw new HttpException(401, "Unauthorized");
        }

        [HttpGet]
        public ActionResult Enregistrement()
        {
            GetCaptcha();
            Identite id = new Identite();
            return View(id);
        }

        public ActionResult GetCaptcha()
        {
            Session["CAPTCHA"] = GetRandomText();
            return new HttpStatusCodeResult(System.Net.HttpStatusCode.OK);
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Enregistrement(Identite identity)
        {
            string clientCaptcha = identity.clientCaptcha;
            string serverCaptcha = Session["CAPTCHA"].ToString();

            if (ModelState.IsValid && clientCaptcha.Equals(serverCaptcha)) return RedirectToAction("Index");
            else if(ModelState.IsValid)
            {
                ViewBag.ShowCAPTCHA = serverCaptcha;
                ViewBag.CaptchaError = "Captcha invalid";
                return View(identity);
            }
            else
            {
                ModelState.AddModelError("", "OH NON");
                return View(identity);
            }
        }

        public JsonResult IsCaptchaCorrect(string clientCaptcha)
        {
            string serverCaptcha = Session["CAPTCHA"].ToString();

            return Json(serverCaptcha.Equals(clientCaptcha), JsonRequestBehavior.AllowGet);
        }

        public FileResult GetCaptchaImage()
        {
            string text = Session["CAPTCHA"].ToString();

            Random rnd = new Random();
            Image img = new Bitmap(1, 1);
            Graphics drawing = Graphics.FromImage(img);

            Font font = new Font("Arial", 15);
            SizeF textSize = drawing.MeasureString(text, font);

            img.Dispose();
            drawing.Dispose();

            img = new Bitmap((int)textSize.Width + 40, (int)textSize.Height + 20);
            drawing = Graphics.FromImage(img);
            drawing.TextRenderingHint = TextRenderingHint.AntiAlias;
            HatchStyle[] aHatchStyles = new HatchStyle[]
                        {
            HatchStyle.BackwardDiagonal, HatchStyle.Cross, HatchStyle.DashedDownwardDiagonal, HatchStyle.DashedHorizontal,
            HatchStyle.DashedUpwardDiagonal, HatchStyle.DashedVertical, HatchStyle.DiagonalBrick, HatchStyle.DiagonalCross,
            HatchStyle.Divot, HatchStyle.DottedDiamond, HatchStyle.DottedGrid, HatchStyle.ForwardDiagonal, HatchStyle.Horizontal,
            HatchStyle.HorizontalBrick, HatchStyle.LargeCheckerBoard, HatchStyle.LargeConfetti, HatchStyle.LargeGrid,
            HatchStyle.LightDownwardDiagonal, HatchStyle.LightHorizontal, HatchStyle.LightUpwardDiagonal, HatchStyle.LightVertical,
            HatchStyle.Max, HatchStyle.Min, HatchStyle.NarrowHorizontal, HatchStyle.NarrowVertical, HatchStyle.OutlinedDiamond,
            HatchStyle.Plaid, HatchStyle.Shingle, HatchStyle.SmallCheckerBoard, HatchStyle.SmallConfetti, HatchStyle.SmallGrid,
            HatchStyle.SolidDiamond, HatchStyle.Sphere, HatchStyle.Trellis, HatchStyle.Vertical, HatchStyle.Wave, HatchStyle.Weave,
            HatchStyle.WideDownwardDiagonal, HatchStyle.WideUpwardDiagonal, HatchStyle.ZigZag
                        };
            Color backColor = Color.FromArgb(rnd.Next(256), rnd.Next(256), rnd.Next(256));
            Color textColor = Color.FromArgb(rnd.Next(256), rnd.Next(256), rnd.Next(256));
            RectangleF oRectangleF = new RectangleF(0, 0, textSize.Width + 40, textSize.Height + 20);
            Brush oBrush = new HatchBrush(aHatchStyles[rnd.Next(aHatchStyles.Length - 1)], Color.FromArgb(rnd.Next(256), rnd.Next(256), rnd.Next(256)), Color.FromArgb(255, 255, 255));
            drawing.FillRectangle(oBrush, oRectangleF);

            Brush textBrush = new SolidBrush(textColor);

            drawing.DrawString(text, font, textBrush, 20, 10);

            drawing.Save();

            font.Dispose();
            textBrush.Dispose();
            drawing.Dispose();

            MemoryStream ms = new MemoryStream();
            img.Save(ms, System.Drawing.Imaging.ImageFormat.Png);
            img.Dispose();

            return File(ms.ToArray(), "image/png");
        }

        private string GetRandomText()
        {
            StringBuilder randomText = new StringBuilder();
            string alphabets = "012345679ACEFGHKLMNPRSWXZabcdefghijkhlmnopqrstuvwxyz";
            Random r = new Random();
            for (int j = 0; j <= 5; j++)
            {
                randomText.Append(alphabets[r.Next(alphabets.Length)]);
            }
            return randomText.ToString();
        }
    }
}