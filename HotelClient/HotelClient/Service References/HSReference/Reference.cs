﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace HotelClient.HSReference {
    using System.Runtime.Serialization;
    using System;
    
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Runtime.Serialization", "4.0.0.0")]
    [System.Runtime.Serialization.DataContractAttribute(Name="Room", Namespace="http://schemas.datacontract.org/2004/07/HotelBookingService")]
    [System.SerializableAttribute()]
    public partial class Room : object, System.Runtime.Serialization.IExtensibleDataObject, System.ComponentModel.INotifyPropertyChanged {
        
        [System.NonSerializedAttribute()]
        private System.Runtime.Serialization.ExtensionDataObject extensionDataField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string IsBookedField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int OccupacyField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int RPriceField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private string RTypeField;
        
        [System.Runtime.Serialization.OptionalFieldAttribute()]
        private int RoomNoField;
        
        [global::System.ComponentModel.BrowsableAttribute(false)]
        public System.Runtime.Serialization.ExtensionDataObject ExtensionData {
            get {
                return this.extensionDataField;
            }
            set {
                this.extensionDataField = value;
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string IsBooked {
            get {
                return this.IsBookedField;
            }
            set {
                if ((object.ReferenceEquals(this.IsBookedField, value) != true)) {
                    this.IsBookedField = value;
                    this.RaisePropertyChanged("IsBooked");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int Occupacy {
            get {
                return this.OccupacyField;
            }
            set {
                if ((this.OccupacyField.Equals(value) != true)) {
                    this.OccupacyField = value;
                    this.RaisePropertyChanged("Occupacy");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int RPrice {
            get {
                return this.RPriceField;
            }
            set {
                if ((this.RPriceField.Equals(value) != true)) {
                    this.RPriceField = value;
                    this.RaisePropertyChanged("RPrice");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public string RType {
            get {
                return this.RTypeField;
            }
            set {
                if ((object.ReferenceEquals(this.RTypeField, value) != true)) {
                    this.RTypeField = value;
                    this.RaisePropertyChanged("RType");
                }
            }
        }
        
        [System.Runtime.Serialization.DataMemberAttribute()]
        public int RoomNo {
            get {
                return this.RoomNoField;
            }
            set {
                if ((this.RoomNoField.Equals(value) != true)) {
                    this.RoomNoField = value;
                    this.RaisePropertyChanged("RoomNo");
                }
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(ConfigurationName="HSReference.IService1")]
    public interface IService1 {
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/getRooms", ReplyAction="http://tempuri.org/IService1/getRoomsResponse")]
        HotelClient.HSReference.Room[] getRooms();
        
        [System.ServiceModel.OperationContractAttribute(Action="http://tempuri.org/IService1/getRooms", ReplyAction="http://tempuri.org/IService1/getRoomsResponse")]
        System.Threading.Tasks.Task<HotelClient.HSReference.Room[]> getRoomsAsync();
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IService1Channel : HotelClient.HSReference.IService1, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class Service1Client : System.ServiceModel.ClientBase<HotelClient.HSReference.IService1>, HotelClient.HSReference.IService1 {
        
        public Service1Client() {
        }
        
        public Service1Client(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public Service1Client(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Service1Client(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public Service1Client(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        public HotelClient.HSReference.Room[] getRooms() {
            return base.Channel.getRooms();
        }
        
        public System.Threading.Tasks.Task<HotelClient.HSReference.Room[]> getRoomsAsync() {
            return base.Channel.getRoomsAsync();
        }
    }
}
