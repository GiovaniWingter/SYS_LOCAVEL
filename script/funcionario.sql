USE [INF3AT]
GO

/****** Object:  Table [dbo].[funcionario]    Script Date: 09/15/2012 11:41:32 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[funcionario](
	[idFuncionario] [int] IDENTITY(1,1) NOT NULL,
	[nome_funcionario] [varchar](70) NULL,
	[sexo] [char](1) NULL,
	[cpf_funcionario] [varchar](14) NULL,
	[rg_funcionario] [varchar](13) NULL,
	[email_funcionario] [varchar](70) NULL,
	[login_funcionario] [varchar](30) NULL,
	[senha_funcionario] [varchar](20) NULL,
 CONSTRAINT [PK_funcionario] PRIMARY KEY CLUSTERED 
(
	[idFuncionario] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

