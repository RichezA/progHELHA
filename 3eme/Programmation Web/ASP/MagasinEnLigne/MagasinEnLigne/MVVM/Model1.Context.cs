﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace MagasinEnLigne.MVVM
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Infrastructure;
    using System.Data.Entity.Core.Objects;
    using System.Linq;
    
    public partial class WebEssaiExamEntities : DbContext
    {
        public WebEssaiExamEntities()
            : base("name=WebEssaiExamEntities")
        {
        }
    
        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            throw new UnintentionalCodeFirstException();
        }
    
        public virtual DbSet<Article> Articles { get; set; }
    
        public virtual ObjectResult<GetArticles_Result> GetArticles()
        {
            return ((IObjectContextAdapter)this).ObjectContext.ExecuteFunction<GetArticles_Result>("GetArticles");
        }
    }
}
