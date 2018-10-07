
-- --------------------------------------------------
-- Entity Designer DDL Script for SQL Server 2005, 2008, 2012 and Azure
-- --------------------------------------------------
-- Date Created: 04/20/2018 12:08:16
-- Generated from EDMX file: C:\Users\User\Desktop\COURS\1 ERE\PROGRA\EXOS PROG Q2\Entity Framework Model First\Entity Framework Model First\Database.edmx
-- --------------------------------------------------

SET QUOTED_IDENTIFIER OFF;
GO
USE [TestDatabase];
GO
IF SCHEMA_ID(N'dbo') IS NULL EXECUTE(N'CREATE SCHEMA [dbo]');
GO

-- --------------------------------------------------
-- Dropping existing FOREIGN KEY constraints
-- --------------------------------------------------


-- --------------------------------------------------
-- Dropping existing tables
-- --------------------------------------------------


-- --------------------------------------------------
-- Creating all tables
-- --------------------------------------------------

-- Creating table 'VehiculeSet'
CREATE TABLE [dbo].[VehiculeSet] (
    [idVehicule] int IDENTITY(1,1) NOT NULL,
    [cylindree] smallint  NOT NULL,
    [marque] nvarchar(50)  NOT NULL
);
GO

-- --------------------------------------------------
-- Creating all PRIMARY KEY constraints
-- --------------------------------------------------

-- Creating primary key on [idVehicule] in table 'VehiculeSet'
ALTER TABLE [dbo].[VehiculeSet]
ADD CONSTRAINT [PK_VehiculeSet]
    PRIMARY KEY CLUSTERED ([idVehicule] ASC);
GO

-- --------------------------------------------------
-- Creating all FOREIGN KEY constraints
-- --------------------------------------------------

-- --------------------------------------------------
-- Script has ended
-- --------------------------------------------------