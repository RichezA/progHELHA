using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace RoutedEventPgb
{
    class CustomProgressBar : ProgressBar
    {
        public double AlertLevel { get; set; }

        public static readonly RoutedEvent AlertEvent = EventManager.RegisterRoutedEvent("Alert", RoutingStrategy.Bubble, typeof(RoutedEventHandler), typeof(CustomProgressBar));
    
        public event RoutedEventHandler Alert
        {
            add
            {
                this.AddHandler(CustomProgressBar.AlertEvent, value);
            }
            remove
            {
                this.RemoveHandler(CustomProgressBar.AlertEvent, value);
            }
        }
    }
}
