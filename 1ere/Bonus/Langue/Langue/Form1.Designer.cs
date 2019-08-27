namespace Langue
{
    partial class Form1
    {
        /// <summary>
        /// Variable nécessaire au concepteur.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Nettoyage des ressources utilisées.
        /// </summary>
        /// <param name="disposing">true si les ressources managées doivent être supprimées ; sinon, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Code généré par le Concepteur Windows Form

        /// <summary>
        /// Méthode requise pour la prise en charge du concepteur - ne modifiez pas
        /// le contenu de cette méthode avec l'éditeur de code.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.btCancel = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.dateTb = new System.Windows.Forms.TextBox();
            this.montantLabel = new System.Windows.Forms.Label();
            this.dateLabel = new System.Windows.Forms.Label();
            this.cbCulture = new System.Windows.Forms.ComboBox();
            this.SuspendLayout();
            // 
            // btCancel
            // 
            resources.ApplyResources(this.btCancel, "btCancel");
            this.btCancel.Name = "btCancel";
            this.btCancel.UseVisualStyleBackColor = true;
            this.btCancel.Click += new System.EventHandler(this.btCancel_Click);
            // 
            // textBox1
            // 
            resources.ApplyResources(this.textBox1, "textBox1");
            this.textBox1.Name = "textBox1";
            // 
            // dateTb
            // 
            resources.ApplyResources(this.dateTb, "dateTb");
            this.dateTb.Name = "dateTb";
            // 
            // montantLabel
            // 
            resources.ApplyResources(this.montantLabel, "montantLabel");
            this.montantLabel.Name = "montantLabel";
            // 
            // dateLabel
            // 
            resources.ApplyResources(this.dateLabel, "dateLabel");
            this.dateLabel.Name = "dateLabel";
            // 
            // cbCulture
            // 
            this.cbCulture.FormattingEnabled = true;
            resources.ApplyResources(this.cbCulture, "cbCulture");
            this.cbCulture.Name = "cbCulture";
            this.cbCulture.SelectedIndexChanged += new System.EventHandler(this.cbCulture_SelectedIndexChanged);
            // 
            // Form1
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.Controls.Add(this.cbCulture);
            this.Controls.Add(this.dateLabel);
            this.Controls.Add(this.montantLabel);
            this.Controls.Add(this.dateTb);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.btCancel);
            this.Name = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btCancel;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox dateTb;
        private System.Windows.Forms.Label montantLabel;
        private System.Windows.Forms.Label dateLabel;
        private System.Windows.Forms.ComboBox cbCulture;
    }
}

